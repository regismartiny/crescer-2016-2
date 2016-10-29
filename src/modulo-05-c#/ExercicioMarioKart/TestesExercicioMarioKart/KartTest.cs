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
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Kart(corredor);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(0, kart.Equipamentos.Count);
            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void KartNasceComCorredorEEquipaMotorABaseDeLava()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Kart(corredor);
            var motor = new MotorABaseDeLava();
            kart.Equipar(motor);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(9, kart.Velocidade);
        }

        [TestMethod]
        public void KartNasceComCorredorEEquipaPneusDeCouroDeDragao()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.MEDIANO);
            var kart = new Kart(corredor);
            var pneus = new PneusDeCouroDeDragao();
            kart.Equipar(pneus);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(10, kart.Velocidade);
        }

        [TestMethod]
        public void KartNasceComCorredorEEquipaPneusDeCouroDeDragaoEMotorABaseDeLava()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.PROFISSIONAL);
            var kart = new Kart(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();
            kart.Equipar(pneus);
            kart.Equipar(motor);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(16, kart.Velocidade);
        }
    }
}

