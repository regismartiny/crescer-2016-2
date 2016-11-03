using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        public string Imagem { get; set; } = "blanka.png";
        public string Nome { get; set; }
        [DisplayName("Data Nascimento")]
        public DateTime DataNascimento { get; set; } = DateTime.Parse("12/02/1966");
        public int Altura = 192;
        public decimal Peso = 96;
        /*public string Medidas = "B198, C120, Q172";
        public char TipoSanguineo = 'B';
        public string HabilidadesEspeciais = "Caçar, Eletricidade";
        public string Gosta = "Frutas tropicais, Pirarucu, Sua mãe";
        public string Desgosta = "Army ants (espécie de formiga)";
        public string EstiloDeLuta = "Luta Selvagem autodidata (Army Ants) / Capoeira";
        public string UmaFalaDeVitoria = "\"Ver você em ação é uma piada!\"";
        public string SSF2Nickname = "\"A selvagem criança da natureza\"";
        public string SFA3Nickname = "\"A animal pessoa amazônica\"";
        public string SF4Nickname = "\"Guerreiro da selva\"";
        public string SFA3Stage = "Ramificação do Rio Madeira - pantano, Brasil (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?)";
        public string SF2Stage = "Bacia do rio Amazonas (Brasil)";*/
        public string Origem { get; set; } = "Brasil (lugar de nascença é provável como sendo Tailândia)";
        [DisplayName("Golpes especiais")]
        public string GolpesEspeciais { get; set; } = "Electric Thunder, Rolling Attack";
        [DisplayName("Personagem oculto?")]
        public Boolean PersonagemOculto { get; set; }
    }
}