using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; private set; }
        public string Imagem { get; private set; }
        public string Nome { get; private set; }
        public DateTime DataNascimento { get; set; }
        public int Altura { get; set; }
        public decimal Peso { get; set; }
        public string Origem { get; private set; }
        public string GolpesEspeciais { get; set; }
        public Boolean PersonagemOculto { get; set; }

        public Personagem() { }

        public Personagem(int id, string imagem, string nome, DateTime dataNascimento, int altura, 
            decimal peso,string origem, string golpesEspeciais, bool personagemOculto)
            : this(imagem, nome, dataNascimento, altura, peso, origem, golpesEspeciais, personagemOculto)
        {
            this.Id = id;
        }

        public Personagem(string imagem, string nome, DateTime dataNascimento, int altura,
            decimal peso, string origem, string golpesEspeciais, bool personagemOculto)
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException("Não é permitido cadastrar personagens overpowered.");
            else {
                if (origem.ToUpperInvariant().Contains("Morro da Pedra"))
                    throw new RegraNegocioException($"Somente um personagem pode ser dessa região e esse personagem não é o {nome}.");
            }
            this.Imagem = imagem;
            this.Nome = nome;
            this.DataNascimento = dataNascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
        }
    }
}
