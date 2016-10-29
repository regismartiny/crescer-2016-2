using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace TestesExercicioMarioKart
{
    [TestClass]
    public class KartTest
    {
        [TestMethod]
        public void KartNasceComCorredorESemEquipamentos()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.MEDIANO);
            var kart = new Kart(corredor);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(0, kart.Equipamentos.Count);
            Assert.AreEqual(8, kart.Velocidade);
        }

        [TestMethod]
        public void KartNasceComCorredorEEquipaMotorABaseDeLava()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.MEDIANO);
            var kart = new Kart(corredor);
            var motor = new MotorABaseDeLava();
            kart.Equipar(motor);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(motor, kart.Equipamentos[0]);
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void KartNasceComCorredorEEquipaPneusDeDragao()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Kart(corredor);
            var pneus = new PneusDeCouroDeDragao();
            kart.Equipar(pneus);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(pneus, kart.Equipamentos[0]);
            Assert.AreEqual(8, kart.Velocidade);
        }
    }
}
