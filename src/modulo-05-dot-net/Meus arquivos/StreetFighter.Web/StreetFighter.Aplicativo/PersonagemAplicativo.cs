using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            return repositorio.ListarPersonagens(filtroNome);   
        }

        public List<Personagem> ListarPersonagensBanco(string filtroNome)
        {
            return repositorio.ListarPersonagensBanco(filtroNome);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0) //inclusão
            {
                repositorio.IncluirPersonagem(personagem);
            }else
            {
                repositorio.EditarPersonagem(personagem);
            }
        }

        public bool ExcluirPersonagem(string idPersonagem)
        {
            return repositorio.ExcluirPersonagem(idPersonagem);
        }

        public Personagem ObterPersonagem(string idPersonagem)
        {
            return repositorio.ObterPersonagem(idPersonagem);
        }

        public Personagem ObterPersonagemBanco(string idPersonagem)
        {
            return repositorio.ObterPersonagemBanco(idPersonagem);
        }
    }
}
