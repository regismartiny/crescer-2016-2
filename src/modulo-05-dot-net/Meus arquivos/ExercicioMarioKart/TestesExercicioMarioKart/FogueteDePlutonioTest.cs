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

            Assert.AreEqual(NivelEquipamento.DOIS, foguete.Nivel);
            Assert.AreEqual(2, foguete.Bonus);
        }

        [TestMethod]
        public void FogueteDePlutonioNasceComNivel4Bonus4()
        {
            var foguete = new FogueteDePlutonio(NivelEquipamento.QUATRO);

            Assert.AreEqual(NivelEquipamento.QUATRO, foguete.Nivel);
            Assert.AreEqual(4, foguete.Bonus);
        }

        [TestMethod]
        public void FogueteDePlutonioNasceComNive2SobeParaNivel3()
        {
            var foguete = new FogueteDePlutonio();
            foguete.Nivel = NivelEquipamento.TRES;

            Assert.AreEqual(NivelEquipamento.TRES, foguete.Nivel);
            Assert.AreEqual(3, foguete.Bonus);
        }
    }
}
