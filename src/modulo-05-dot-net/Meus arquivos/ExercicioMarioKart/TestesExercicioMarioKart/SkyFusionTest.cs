using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;

namespace TestesExercicioMarioKart
{
    [TestClass]
    public class SkyFusionTest
    {
        [TestMethod]
        public void SkyFusionComCorredorNoobSemEquipamentoPossuiVelocidade7()
        {
            var corredor = new Corredor("Ben-hur", NivelDeHabilidade.NOOB);
            var kart = new SkyFusion(corredor);

            Assert.AreEqual(6, kart.Velocidade);//3 + 0 + 3
        }

        [TestMethod]
        public void SkyFusionComCorredorProfissionalEquipadoComMotorABaseDeLava()
        {
            var corredor = new Corredor("Regis", NivelDeHabilidade.PROFISSIONAL);
            var kart = new SkyFusion(corredor);
            var equip = new MotorABaseDeLava();//bonus = 3
            kart.Equipar(equip);

            Assert.AreEqual(13, kart.Velocidade);//3 + 3 + 6 + 1
        }

        [TestMethod]
        public void SkyFusionComCorredorProfissionalEquipadoComSkyFusionQueEhEquipadoComMotorABaseDeLava()
        {
            var corredor = new Corredor("Regis", NivelDeHabilidade.PROFISSIONAL);
            var kart = new SkyFusion(corredor);
            var equipInterno = new MotorABaseDeLava();//bonus = 3
            var equipExterno = new SkyFusion(corredor);//bonus = 1 + 3 + (5) = 9
            equipExterno.Equipar(equipInterno);
            kart.Equipar(equipExterno);

            Assert.AreEqual(19, kart.Velocidade);//3 + 9 + 6 + 1
        }

        [TestMethod]
        public void SkyFusionComCorredorProfissionalEquipadoComSkyFusionQueEhEquipadoComSkyFusionQueEhEquipadoComMotorABaseDeLava()
        {
            var corredor = new Corredor("Regis", NivelDeHabilidade.PROFISSIONAL);
            var kart = new SkyFusion(corredor);
            var equipMaisInterno = new MotorABaseDeLava();//bonus = 3
            var equipInterno = new SkyFusion(corredor);//bonus = 1 + 3 = 4
            equipInterno.Equipar(equipMaisInterno);
            var equipExterno = new SkyFusion(corredor);//bonus = 1 + 3 + (5) = 9
            equipExterno.Equipar(equipInterno);
            kart.Equipar(equipExterno);

            Assert.AreEqual(19, kart.Velocidade);//3 + 9 + 6 + 1
        }
    }
}
