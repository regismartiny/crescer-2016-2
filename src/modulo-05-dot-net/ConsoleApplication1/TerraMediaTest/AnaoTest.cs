using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Personagens;

namespace TerraMediaTest
{
    [TestClass]
    public class AnaoTest
    {
        [TestMethod]
        public void AnaoRecebeAtaqueDeOrcFicaCom15DeVida()
        {
            var orc = new Orc();
            var anao = new Anao();

            orc.Atacar(anao);

            Assert.AreEqual(15, anao.Vida);

        }
    }
}
