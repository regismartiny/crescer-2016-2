using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace TestesExercicioMarioKart
{
    [TestClass]
    public class SonnarTest
    {
        [TestMethod]
        public void KartSonnarSemEquipamentos()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Sonnar(corredor);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(0, kart.Equipamentos.Count);
            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void KartSonnarEquipaPneusDeCouroDeDragao()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Sonnar(corredor);
            var equip = new PneusDeCouroDeDragao();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(10, kart.Velocidade);
        }

        [TestMethod]
        public void KartSonnarEquipaMotorABaseDeLava()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Sonnar(corredor);
            var equip = new MotorABaseDeLava();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void KartSonnarEquipaPneusDeCouroDeDragaoEMotorABaseDeLava()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Sonnar(corredor);
            IEquipamentos equip = new MotorABaseDeLava();
            kart.Equipar(equip);
            equip = new PneusDeCouroDeDragao();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(13, kart.Velocidade);
        }
    }
}
