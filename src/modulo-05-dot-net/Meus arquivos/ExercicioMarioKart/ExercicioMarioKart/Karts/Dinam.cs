using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Dinam : Kart
    {
        public Dinam(Corredor corredor) : base(corredor)
        {
        }

        protected override int GetVelocidadeExtra()
        {
            int extra = 0;
            if (this.Corredor.NivelHabilidade == NivelDeHabilidade.NOOB)
                extra = 3;
            else if (this.Corredor.NivelHabilidade == NivelDeHabilidade.MEDIANO)
                extra = 5;
            else if (this.Corredor.NivelHabilidade == NivelDeHabilidade.PROFISSIONAL)
            {
                extra = 6;
            }
            return extra;
        }
    }

    
}
