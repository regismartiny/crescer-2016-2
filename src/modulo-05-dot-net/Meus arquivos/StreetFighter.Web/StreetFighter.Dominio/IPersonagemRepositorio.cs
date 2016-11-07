using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public interface IPersonagemRepositorio
    {
        List<Personagem> ListarPersonagens(string filtroNome);

        List<Personagem> ListarPersonagensBanco(string filtroNome);

        void IncluirPersonagem(Personagem personagem);

        bool ExcluirPersonagem(string idPersonagem);

        void EditarPersonagem(Personagem personagem);

        Personagem ObterPersonagem(string idPersonagem);

        Personagem ObterPersonagemBanco(string idPersonagem);
    }
}
