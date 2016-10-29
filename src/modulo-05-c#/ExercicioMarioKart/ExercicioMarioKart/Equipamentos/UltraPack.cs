using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Equipamentos
{
    class UltraPack : IEquipamentos
    {
        public UltraPack(IEquipamentos equipamentoInterno)
        {
            this.EquipamentoInterno = equipamentoInterno;
        }
        public IEquipamentos EquipamentoInterno { get; set; }
        public int Bonus
        {
            get
            {
                return (int)(this.EquipamentoInterno.Bonus * 1.2);
            }
        }
    }
}
