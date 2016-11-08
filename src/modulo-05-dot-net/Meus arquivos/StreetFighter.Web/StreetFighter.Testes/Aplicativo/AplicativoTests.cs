using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;
using StreetFighter.Aplicativo;

namespace StreetFighter.Testes
{
    [TestClass]
    public class AplicativoTests
    {
        [TestMethod]
        public void ObterPersonagemId1DoBanco()
        {
            var personagemAplicativo = new PersonagemAplicativo();
            Personagem p = personagemAplicativo.ObterPersonagemBanco("1");

            Assert.IsNotNull(p);
        }
    }
}
