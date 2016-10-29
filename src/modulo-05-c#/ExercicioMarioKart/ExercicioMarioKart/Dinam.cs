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

        protected override int CalcularBonusExtra()
        {
            int bonus = 0;
            if (this.Corredor.NivelHabilidade == NivelDeHabilidade.NOOB)
                bonus = 3;
            else if (this.Corredor.NivelHabilidade == NivelDeHabilidade.MEDIANO)
                bonus = 5;
            else if (this.Corredor.NivelHabilidade == NivelDeHabilidade.PROFISSIONAL)
            {
                bonus = 6;
            }
            return bonus;
        }
    }

    
}
