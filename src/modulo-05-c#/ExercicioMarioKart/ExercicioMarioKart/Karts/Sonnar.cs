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

        public override int Velocidade
        {
            get
            {
                int velocidadePadrao = 3;
                int bonusEquipamentos = this.GetBonusEquipamentos();
                int bonusHabilidade = this.GetBonusHabilidade();
                int bonusExtra = this.Equipamentos.Count > 0 ? 2 : 0;
                return velocidadePadrao + bonusEquipamentos + bonusHabilidade + bonusExtra;
            }
        }
    }
}
