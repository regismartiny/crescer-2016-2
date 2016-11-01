using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace TestesExercicioMarioKart
{
    [TestClass]
    public class FogueteDePlutonioTest
    {
        [TestMethod]
        public void FogueteDePlutonioNasceComNivel2Bonus2()
        {
            var foguete = new FogueteDePlutonio();

            Assert.AreEqual(2, foguete.Nivel);
            Assert.AreEqual(2, foguete.Bonus);
        }

        [TestMethod]
        public void FogueteDePlutonioNasceComNivel4Bonus4()
        {
            var foguete = new FogueteDePlutonio(4);

            Assert.AreEqual(4, foguete.Nivel);
            Assert.AreEqual(4, foguete.Bonus);
        }

        [TestMethod]
        public void FogueteDePlutonioNasceComNive2SobeParaNivel3()
        {
            var foguete = new FogueteDePlutonio();
            foguete.Nivel = 3;

            Assert.AreEqual(3, foguete.Nivel);
            Assert.AreEqual(3, foguete.Bonus);
        }
    }
}
