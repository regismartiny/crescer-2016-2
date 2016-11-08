using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.IO;
using System.Transactions;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {

        /// <summary>
        ////////////////////////// ARQUIVO //////////////////////////////////////////////////////////////
        /// </summary>
        private const string ARQUIVO = @"C:/temp/personagens.csv";

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            List<Personagem> personagems = new List<Personagem>();
            List<String> conteudoArquivo = LerArquivo();
            foreach(String linha in conteudoArquivo)
            {
                String[] dados = linha.Split(';');
                Personagem personagem = new Personagem(Int32.Parse(dados[0]), dados[1], dados[2], DateTime.Parse(dados[3]), 
                    Int32.Parse(dados[4]), Decimal.Parse(dados[5]), dados[6], dados[7], Boolean.Parse(dados[8]));
                personagems.Add(personagem);
            }

            if (filtroNome != null)
                return personagems.FindAll(p => p.Nome.ToLower().Contains(filtroNome.ToLower()));
            else
                return personagems;
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            String txt = $"{personagem.Id};{personagem.Imagem};{personagem.Nome};{personagem.DataNascimento};{personagem.Altura};{personagem.Peso};{personagem.Origem};{personagem.GolpesEspeciais};{personagem.PersonagemOculto}";
            using (System.IO.StreamWriter file =
            new System.IO.StreamWriter(ARQUIVO, true))
            {
                file.WriteLine(txt);
            }

        }

        public bool ExcluirPersonagem(string idPersonagem)
        {
            List<String> conteudoArquivo = LerArquivo();
            int linhaPersonagem = -1;
            for (int i = 0; i < conteudoArquivo.Count; i++)
            {
                String linha = conteudoArquivo[i];
                String[] dados = linha.Split(';');
                string id = dados[0];
                if (id.Equals(idPersonagem))
                {
                    linhaPersonagem = i;
                }
            }
            if (linhaPersonagem == -1)
                return false;

            conteudoArquivo.RemoveAt(linhaPersonagem);
            GravarArquivo(conteudoArquivo);
            return true;
        }

        public Personagem ObterPersonagem(string idPersonagem)
        {
            List<String> conteudoArquivo = LerArquivo();
            foreach (String linha in conteudoArquivo)
            {
                String[] dados = linha.Split(';');
                string id = dados[0];
                if (idPersonagem.Equals(id))
                {
                    Personagem personagem = new Personagem(Int32.Parse(id), dados[1], dados[2], DateTime.Parse(dados[3]),
                        Int32.Parse(dados[4]), Decimal.Parse(dados[5]), dados[6], dados[7], Boolean.Parse(dados[8]));
                    return personagem;
                }
            }
            return null;
        }

        private List<String> LerArquivo()
        {
            List<String> conteudo = new List<String>();
            if (!File.Exists(ARQUIVO))
                return null;
            using (System.IO.StreamReader file =
            new System.IO.StreamReader(ARQUIVO, true))
            {
                while (!file.EndOfStream)
                {
                    conteudo.Add(file.ReadLine());
                }
            }
            return conteudo;
        }

        private void GravarArquivo(List<String> conteudo)
        {
            using (System.IO.StreamWriter file =
            new System.IO.StreamWriter(ARQUIVO, false))
            {
                foreach (String linha in conteudo)
                {
                    file.WriteLine(linha);
                }
            }
        }

        /// <summary>
        /// ///////////////////////////////////////////////////////////////////////////////////////
        /// </summary>
        /// 
        ////////////////////////////////////////BANCO/////////////////////////////////////////////////

        public List<Personagem> ListarPersonagensBanco(string filtro)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["CrescerConnection"]
                                    .ConnectionString;

            List<Personagem> encontrados = new List<Personagem>();

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Nome LIKE @param_nome";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_nome", $"%{filtro}%"));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    encontrados.Add(ConvertReaderToPersonagem(reader));
                }

                connection.Close();

            }
            return encontrados;
        }

        
        public Personagem ObterPersonagemBanco(string idPersonagem)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["CrescerConnection"]
                                    .ConnectionString;

            Personagem encontrado = null;

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Id = @param_id";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_id", idPersonagem));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    encontrado = ConvertReaderToPersonagem(reader);
                }

                connection.Close();

            }
            return encontrado;
        }

        public void SalvarPersonagemBanco(Personagem personagem)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["CrescerConnection"]
                                    .ConnectionString;

            var result = new List<Personagem>();

            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();
                    string sql = "";
                    var parameters = new List<SqlParameter>();
                    parameters.Add(new SqlParameter("param_imagem", personagem.Imagem));
                    parameters.Add(new SqlParameter("param_nome", personagem.Nome));
                    parameters.Add(new SqlParameter("param_dtnasc", personagem.DataNascimento));
                    parameters.Add(new SqlParameter("param_altura", personagem.Altura));
                    parameters.Add(new SqlParameter("param_peso", personagem.Peso));
                    parameters.Add(new SqlParameter("param_origem", personagem.Origem));
                    parameters.Add(new SqlParameter("param_golpes", personagem.GolpesEspeciais));
                    parameters.Add(new SqlParameter("param_oculto", personagem.PersonagemOculto));
                    if (personagem.Id > 0)
                    {
                        sql = "UPDATE Personagem SET Imagem=@param_imagem, Nome=@param_nome, DataNascimento=@param_dtnasc, Altura=@param_altura, Peso=@param_peso, Origem=@param_origem, GolpesEspeciais=@param_golpes, PersonagemOculto=@param_oculto WHERE Id = @param_id";
                        parameters.Add(new SqlParameter("param_id", personagem.Id));
                    }
                    else
                    {
                        sql = $"INSERT INTO Personagem (Imagem,Nome,DataNascimento,Altura,Peso,Origem,GolpesEspeciais,PersonagemOculto) values (@param_imagem,@param_nome,@param_dtnasc,@param_altura,@param_peso,@param_origem,@param_golpes,@param_oculto)";
                    }

                    var command = new SqlCommand(sql, connection);
                    foreach (SqlParameter param in parameters)
                    {
                        command.Parameters.Add(param);
                    }
                    command.ExecuteNonQuery();
                    transaction.Complete();
                }
                catch (Exception ex)
                {
                    //... 
                }
                finally
                {
                    connection.Close();
                }
            }
        }


        private Personagem ConvertReaderToPersonagem(SqlDataReader reader)
        {
            return new Personagem(Convert.ToInt32(reader["Id"]), reader["Imagem"].ToString(),
                reader["Nome"].ToString(), Convert.ToDateTime(reader["DataNascimento"]),
                Convert.ToInt32(reader["Altura"]), Convert.ToDecimal(reader["Peso"]),
                reader["Origem"].ToString(), reader["GolpesEspeciais"].ToString(),
                Convert.ToBoolean(reader["PersonagemOculto"]));
        }
    }
}
