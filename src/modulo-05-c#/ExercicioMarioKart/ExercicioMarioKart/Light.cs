using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Light : Kart
    {
        public Light(Corredor corredor) : base(corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                int velocidadePadrao = 3;
                int bonusEquipamentos = this.GetBonusEquipamentos();
                int bonusHabilidade = this.GetBonusHabilidade();
                int bonusExtra = CalcularBonusExtra();
                
                return velocidadePadrao + bonusEquipamentos + bonusHabilidade + bonusExtra;
            }
        }

        private int CalcularBonusExtra()
        {
            var habilidade = this.Corredor.NivelHabilidade;
            if (habilidade.Equals(NivelDeHabilidade.NOOB))
            {
                return 3;
            }
            else if (habilidade.Equals(NivelDeHabilidade.PROFISSIONAL))
            {
                return -1;
            }
            return 0;
        }
    }
}
