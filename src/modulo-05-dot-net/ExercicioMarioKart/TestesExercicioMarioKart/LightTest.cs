using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace TestesExercicioMarioKart
{
    [TestClass]
    public class LightTest
    {
        [TestMethod]
        public void KartLightSemEquipamentos()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Light(corredor);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(0, kart.Equipamentos.Count);
            Assert.AreEqual(9, kart.Velocidade);
        }

        [TestMethod]
        public void KartLightEquipaPneusDeCouroDeDragao()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Light(corredor);
            var equip = new PneusDeCouroDeDragao();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void KartLightEquipaMotorABaseDeLava()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Light(corredor);
            var equip = new MotorABaseDeLava();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(12, kart.Velocidade);
        }

        [TestMethod]
        public void KartLightEquipaPneusDeCouroDeDragaoEMotorABaseDeLava()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Light(corredor);
            IEquipamento equip = new MotorABaseDeLava();
            kart.Equipar(equip);
            equip = new PneusDeCouroDeDragao();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(14, kart.Velocidade);
        }

        [TestMethod]
        public void KartLightEquipaMotorABaseDeLavaCorredorPro()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.PROFISSIONAL);
            var kart = new Light(corredor);
            var equip = new MotorABaseDeLava();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(12, kart.Velocidade);
        }

        [TestMethod]
        public void KartLightEquipaPneusDeCouroDeDragaoMotorABaseDeLavaCorredorPro()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.PROFISSIONAL);
            var kart = new Light(corredor);
            IEquipamento equip = new MotorABaseDeLava();
            kart.Equipar(equip);
            equip = new PneusDeCouroDeDragao();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(15, kart.Velocidade);
        }
    }
}
