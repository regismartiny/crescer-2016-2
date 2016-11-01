using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace TestesExercicioMarioKart
{
    [TestClass]
    public class DinamTest
    {
        [TestMethod]
        public void KartDinamSemEquipamentos()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Dinam(corredor);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(0, kart.Equipamentos.Count);
            Assert.AreEqual(9, kart.Velocidade);
        }

        [TestMethod]
        public void KartDinamEquipaPneusDeCouroDeDragao()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Dinam(corredor);
            var equip = new PneusDeCouroDeDragao();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void KartDinamEquipaMotorABaseDeLava()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Dinam(corredor);
            var equip = new MotorABaseDeLava();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(12, kart.Velocidade);
        }

        [TestMethod]
        public void KartLDinamEquipaPneusDeCouroDeDragaoEMotorABaseDeLava()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.NOOB);
            var kart = new Dinam(corredor);
            IEquipamento equip = new MotorABaseDeLava();
            kart.Equipar(equip);
            equip = new PneusDeCouroDeDragao();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(14, kart.Velocidade);
        }

        [TestMethod]
        public void KartDinamEquipaMotorABaseDeLavaCorredorPro()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.PROFISSIONAL);
            var kart = new Dinam(corredor);
            var equip = new MotorABaseDeLava();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(1, kart.Equipamentos.Count);
            Assert.AreEqual(19, kart.Velocidade);
        }

        [TestMethod]
        public void KartDinamEquipaPneusDeCouroDeDragaoEMotorABaseDeLavaCorredorPro()
        {
            var corredor = new Corredor("Joao", NivelDeHabilidade.PROFISSIONAL);
            var kart = new Dinam(corredor);
            IEquipamento equip = new MotorABaseDeLava();
            kart.Equipar(equip);
            equip = new PneusDeCouroDeDragao();
            kart.Equipar(equip);

            Assert.AreEqual(corredor, kart.Corredor);
            Assert.AreEqual(2, kart.Equipamentos.Count);
            Assert.AreEqual(22, kart.Velocidade);
        }
    }
}
