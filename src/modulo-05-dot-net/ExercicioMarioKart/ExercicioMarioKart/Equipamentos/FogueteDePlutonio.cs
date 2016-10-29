using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class FogueteDePlutonio : IEquipamentos
    {
        public FogueteDePlutonio(NivelEquipamento nivel = NivelEquipamento.DOIS)
        {
            this.Nivel = nivel;
        }
        public NivelEquipamento Nivel { get; set; }
        public int Bonus
        {
            get
            {
                return (int)this.Nivel + 1;
            }
        }
    }
}
