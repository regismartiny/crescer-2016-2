using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using StreetFighter.RepositorioEntityFramework;
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
        private readonly PersonagemRepositorioEF repositorioEF;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
            this.repositorioEF = new PersonagemRepositorioEF();
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
            //return repositorio.ListarPersonagensBanco(filtroNome);
            return repositorioEF.GetPersonagens(filtroNome);
        }

        public void Salvar(Personagem personagem)
        {
            //repositorio.SalvarPersonagemBanco(personagem);
            repositorioEF.SalvarPersonagem(personagem);
        }

        public bool ExcluirPersonagem(string idPersonagem)
        {
            return repositorio.ExcluirPersonagem(idPersonagem);
        }

        public Personagem ObterPersonagem(string idPersonagem)
        {
            return repositorio.ObterPersonagem(idPersonagem); 
        }

        public Personagem ObterPersonagemBanco(int idPersonagem)
        {
            //return repositorio.ObterPersonagemBanco(idPersonagem);
            return repositorioEF.GetPersonagemByID(idPersonagem);
        }
    }
}
