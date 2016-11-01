using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {
        public UltraPack(IEquipamento equipamentoInterno)
        {
            this.EquipamentoInterno = equipamentoInterno;
        }
        public IEquipamento EquipamentoInterno { get; set; }
        public int Bonus
        {
            get
            {
                double bonus = EquipamentoInterno.Bonus * 1.2;
                return (int)Math.Ceiling(bonus);
            }
        }
    }
}
