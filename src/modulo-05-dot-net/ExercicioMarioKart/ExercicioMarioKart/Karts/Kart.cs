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
            this.Equipamentos = new List<IEquipamento>();
        }

        public Corredor Corredor { get; set; }

        public List<IEquipamento> Equipamentos { get; set; }

        public virtual int Velocidade
        {
            get
            {
                return CalcularVelocidade();
                
            }
            private set
            {
                this.Velocidade = value;
            }
        }

        protected int CalcularVelocidade()
        {
            int velocidadePadrao = 3;
            int bonusEquipamentos = this.GetBonusEquipamentos();
            int bonusHabilidade = this.GetBonusHabilidade();
            int velocidadeExtra = this.GetVelocidadeExtra();
            return velocidadePadrao + bonusEquipamentos + bonusHabilidade + velocidadeExtra;
        }

        protected int GetBonusEquipamentos()
        {
            int bonus = 0;
            foreach(IEquipamento equipamento in this.Equipamentos)
            {
                bonus += equipamento.Bonus;
            }
            return bonus;
        }

        protected int GetBonusHabilidade()
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

        protected virtual int GetVelocidadeExtra()
        {
            return 0;
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }
    }
}
