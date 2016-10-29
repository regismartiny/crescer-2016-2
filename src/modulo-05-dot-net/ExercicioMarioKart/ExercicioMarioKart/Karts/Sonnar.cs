using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor corredor) : base(corredor)
        {
        }

        protected override int GetVelocidadeExtra()
        {
            return this.Equipamentos.Count > 0 ? 2 : 0;
        }
    }
}
