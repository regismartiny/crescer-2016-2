using Loja.Dominio;
using Loja.Web.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    [CwiAutorizador]
    public class HomeController : Controller
    {
        [HttpGet]
        public ActionResult Index(string filtro)
        {
            var servico = new ProdutoServico(new ProdutoRepositorio());
            List<Produto> produtos = servico.BuscarProdutos(filtro);
            return View(produtos);
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}