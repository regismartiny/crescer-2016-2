using StreetFighter.Dominio;
using System;
using System.Collections.Generic;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        private const string ARQUIVO = @"C:/temp/personagens.csv";
        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            List<Personagem> personagems = new List<Personagem>()
            {
                new Personagem(1, "Blanka", DateTime.Parse("25/11/1989"), 170, 80, "Brasil", "", false),
                new Personagem(2, "Ryu", DateTime.Parse("5/11/1989"), 190, 85, "Japão", "", false)
            };
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

        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }
    }
}
