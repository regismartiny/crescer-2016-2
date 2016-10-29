using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;

namespace ExercicioMarioKartTests
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void CorredorNasceComNomeENivelDeHabilidadeNoob()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.NOOB);
            Assert.AreEqual("Yoshi", corredor.Nome);
            Assert.AreEqual(NivelDeHabilidade.NOOB, corredor.NivelHabilidade);
        }

        [TestMethod]
        public void CorredorNasceComNomeENivelDeHabilidadeMediano()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.MEDIANO);
            Assert.AreEqual("Yoshi", corredor.Nome);
            Assert.AreEqual(NivelDeHabilidade.MEDIANO, corredor.NivelHabilidade);
        }

        [TestMethod]
        public void CorredorNasceComNomeENivelDeHabilidadeProfissional()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.PROFISSIONAL);
            Assert.AreEqual("Yoshi", corredor.Nome);
            Assert.AreEqual(NivelDeHabilidade.PROFISSIONAL, corredor.NivelHabilidade);
        }

    }
}
