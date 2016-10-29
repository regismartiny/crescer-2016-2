using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    class FogueteDePlutonio : IEquipamentos
    {
        public FogueteDePlutonio(Nivel nivel = Nivel.UM)
        {
            this.Nivel = nivel;
        }
        public Nivel Nivel { get; set; }
        public int Bonus
        {
            get
            {
                return (int)this.Nivel + 1;
            }
        }
    }
}
