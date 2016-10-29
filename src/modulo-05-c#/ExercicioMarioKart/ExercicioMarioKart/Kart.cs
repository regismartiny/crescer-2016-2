using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ExercicioMarioKart.Equipamentos;

namespace ExercicioMarioKart
{
    public class Kart
    {
        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            this.Equipamentos = new List<IEquipamentos>();
        }

        public Corredor Corredor { get; set; }

        public List<IEquipamentos> Equipamentos { get; set; }

        public virtual int Velocidade
        {
            get
            {
                int velocidadePadrao = 3;
                int bonusEquipamentos = this.GetBonusEquipamentos();
                int bonusHabilidade = this.GetBonusHabilidade();
                return velocidadePadrao + bonusEquipamentos + bonusHabilidade;
            }
            private set
            {
                this.Velocidade = value;
            }
        }

        private int GetBonusEquipamentos()
        {
            int bonus = 0;
            foreach(IEquipamentos equipamento in this.Equipamentos)
            {
                bonus += equipamento.Bonus;
            }
            return bonus;
        }

        private int GetBonusHabilidade()
        {
            int bonus = 0;
            if (this.Corredor.NivelHabilidade == NivelDeHabilidade.NOOB)
                bonus = 3;
            else if (this.Corredor.NivelHabilidade == NivelDeHabilidade.MEDIANO)
                bonus = 5;
            else if (this.Corredor.NivelHabilidade == NivelDeHabilidade.PROFISSIONAL)
            {
                int qtdEquipamentos = this.Equipamentos.Count;
                bonus = 6 + qtdEquipamentos;
            }
            return bonus;
        }

        public void Equipar(IEquipamentos equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }
    }
}
