using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;

namespace ExercicioMarioKartTests
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void CorredorNasceComNomeENivelDeHabilidade()
        {
            var corredor = new Corredor("Yoshi", 2);
            Assert.AreEqual("Yoshi", corredor.Nome);
            Assert.AreEqual(2, corredor.NivelHabilidade);
        }
    }
}
