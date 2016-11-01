using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class FogueteDePlutonio : IEquipamento
    {
        public FogueteDePlutonio(int nivel = 2)
        {
            if (nivel >= 1 && nivel <= 5)
            {
                this.Nivel = nivel;
            }
            else
            {
                this.Nivel = 2;
            }
        }
        public int Nivel { get; set; }
        public int Bonus
        {
            get
            {
                return (int)this.Nivel;
            }
        }
    }
}
