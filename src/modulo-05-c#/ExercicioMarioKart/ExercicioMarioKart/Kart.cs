using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ExercicioMarioKart.Equipamentos;

namespace ExercicioMarioKart
{
    public abstract class Kart
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
                int bonusEquipamentos = this.getBonusEquipamentos();
                int bonusHabilidade = this.getBonusHabilidade();
                int qtdEquipamentos = this.Equipamentos.Count;
                return velocidadePadrao + bonusEquipamentos + bonusHabilidade + qtdEquipamentos;
            }
            private set
            {
                this.Velocidade = value;
            }
        }

        private int getBonusEquipamentos()
        {
            int bonus = 0;
            foreach(IEquipamentos equipamento in this.Equipamentos)
            {
                bonus += equipamento.Bonus;
            }
            return bonus;
        }

        private int getBonusHabilidade()
        {
            int bonus = 0;
            if (this.Corredor.NivelHabilidade == 1)
                bonus = 3;
            else if (this.Corredor.NivelHabilidade == 2)
                bonus = 5;
            else if (this.Corredor.NivelHabilidade == 3)
                bonus = 6;
            return bonus;
        }
    }
}
