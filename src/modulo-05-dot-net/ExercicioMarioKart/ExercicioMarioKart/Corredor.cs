using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Corredor
    {
        public Corredor(String nome, NivelDeHabilidade nivelDeHabilidade)
        {
            this.Nome = nome;
            this.NivelHabilidade = nivelDeHabilidade;
        }
        public string Nome { get; private set; }
        public NivelDeHabilidade NivelHabilidade { get; set; }
    }
}
