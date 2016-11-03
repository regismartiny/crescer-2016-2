using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            return new List<Personagem>()
            {
                new Personagem(1, "Blanka", "Brasil"),
                new Personagem(1, "Ryu", "Japão")
            };
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }
    }
}
