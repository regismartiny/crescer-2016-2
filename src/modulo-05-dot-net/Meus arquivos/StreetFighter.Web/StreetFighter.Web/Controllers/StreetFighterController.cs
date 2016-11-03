using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cadastro()
        {
            PopularPaises();
            return View();
        }

        public ActionResult Salvar(FichaTecnicaModel model)
        {
            PopularPaises();

            if (ModelState.IsValid)
            {
                ViewBag.Mensagem = "Cadastro concluído com sucesso.";
                return View("FichaTecnica", model);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro.");
                return View("Cadastro");
            }
        }

        public ActionResult FichaTecnica(FichaTecnicaModel model)
        {
            return View(model);
        }

        public ActionResult Sobre(SobreModel model)
        {
            return View(model);
        }

        private void PopularPaises()
        {
            //ViewBag.ListaPersonagens
            ViewData["ListaPaises"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brazil" },
                new SelectListItem() { Value = "AR", Text = "Argentina" },
                new SelectListItem() { Value = "US", Text = "Estados Unidos" },
                new SelectListItem() { Value = "CA", Text = "Canadá" },
                new SelectListItem() { Value = "AU", Text = "Austrália" },
                new SelectListItem() { Value = "IR", Text = "Irlanda" }
            };
        }
    }
}