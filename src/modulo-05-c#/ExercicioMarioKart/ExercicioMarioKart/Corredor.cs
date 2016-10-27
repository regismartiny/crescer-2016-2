using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Corredor
    {
        public Corredor(String nome, int nivelHabilidade = 1)
        {
            this.Nome = nome;
            this.NivelHabilidade = nivelHabilidade;
        }
        public string Nome { get; private set; }
        public int NivelHabilidade { get; set; } //1 = Noob, 2 = Mediano, 3 = Profissional
    }
}
