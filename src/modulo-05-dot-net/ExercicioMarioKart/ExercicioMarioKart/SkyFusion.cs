using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class SkyFusion : Kart, IEquipamento
    {
        public SkyFusion(Corredor corredor) : base(corredor)
        {
        }
        public int Bonus
        {
            get
            {
                var bonus = 0;
                var qtdEquipamentos = this.Equipamentos.Count;
                bonus += qtdEquipamentos;
                var habilidade = this.Corredor.NivelHabilidade;
                if (habilidade.Equals(NivelDeHabilidade.NOOB))
                {
                    bonus += 1;
                }
                else if (habilidade.Equals(NivelDeHabilidade.MEDIANO))
                {
                    bonus += 2;
                }
                else if (habilidade.Equals(NivelDeHabilidade.PROFISSIONAL))
                {
                    bonus += 3;
                }
                return this.Velocidade > 12 ? bonus + 5 : bonus;
            }
        }
    }
}
