using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;
using StreetFighter.Aplicativo;

namespace StreetFighter.Testes
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            var personagemAplicativo = new PersonagemAplicativo();
            Personagem p = personagemAplicativo.ObterPersonagemBanco("1");

            Assert.IsNotNull(p);
        }
    }
}
