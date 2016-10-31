using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace TestesExercicioMarioKart
{
    [TestClass]
    public class UltraPackTest
    {
        [TestMethod]
        public void KartEquipadoComUltraPackQuePossuiPneusDeCouroDeDragao()
        {
            var corredor = new Corredor("Juca", NivelDeHabilidade.MEDIANO);
            var kart = new Kart(corredor);
            var equipInterno = new PneusDeCouroDeDragao();
            var equip = new UltraPack(equipInterno);
            kart.Equipar(equip);

            Assert.AreEqual(1, kart.Equipamentos.Count);
            UltraPack ultrapack = (UltraPack)kart.Equipamentos[0];
            Assert.AreEqual(equip, ultrapack);
            Assert.AreEqual(equipInterno, ultrapack.EquipamentoInterno);
            Assert.AreEqual(3, ultrapack.Bonus);
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void KartEquipadoComUltraPackQuePossuiUltraPack()
        {
            var corredor = new Corredor("Juca", NivelDeHabilidade.MEDIANO);
            var kart = new Kart(corredor);
            var equipNivel3 = new PneusDeCouroDeDragao();
            var equipNivel2 = new UltraPack(equipNivel3);
            var equipNivel1 = new UltraPack(equipNivel2);
            kart.Equipar(equipNivel1);

            Assert.AreEqual(1, kart.Equipamentos.Count);
            UltraPack ultrapackExterno = (UltraPack)kart.Equipamentos[0];
            UltraPack ultrapackInterno = (UltraPack)ultrapackExterno.EquipamentoInterno;
            Assert.AreEqual(equipNivel1, ultrapackExterno);
            Assert.AreEqual(equipNivel2, ultrapackInterno);
            Assert.AreEqual(equipNivel3, ultrapackInterno.EquipamentoInterno);
            Assert.AreEqual(4, ultrapackExterno.Bonus);
            Assert.AreEqual(12, kart.Velocidade);
        }

        [TestMethod]
        public void KartEquipadoComUltraPackQuePossuiUltraPackQuePossuiUltraPack()
        {
            var corredor = new Corredor("Juca", NivelDeHabilidade.MEDIANO);
            var kart = new Kart(corredor);
            var equipNivel4 = new PneusDeCouroDeDragao();
            var equipNivel3 = new UltraPack(equipNivel4);
            var equipNivel2 = new UltraPack(equipNivel3);
            var equipNivel1 = new UltraPack(equipNivel2);
            kart.Equipar(equipNivel1);

            Assert.AreEqual(1, kart.Equipamentos.Count);
            UltraPack ultrapackExterno = (UltraPack)kart.Equipamentos[0];
            UltraPack ultrapackInterno = (UltraPack)ultrapackExterno.EquipamentoInterno;
            UltraPack ultrapackInternoInterno = (UltraPack)ultrapackInterno.EquipamentoInterno;
            Assert.AreEqual(equipNivel1, ultrapackExterno);
            Assert.AreEqual(equipNivel2, ultrapackInterno);
            Assert.AreEqual(equipNivel3, ultrapackInternoInterno);
            Assert.AreEqual(equipNivel4, ultrapackInternoInterno.EquipamentoInterno);
            Assert.AreEqual(5, ultrapackExterno.Bonus);
            Assert.AreEqual(13, kart.Velocidade);
        }
    }
}
