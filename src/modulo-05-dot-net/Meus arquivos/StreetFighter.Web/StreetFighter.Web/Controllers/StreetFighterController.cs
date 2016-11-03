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

        public ActionResult Cadastro(CadastroModel model)
        {
            return View(model);
        }

        public ActionResult FichaTecnica(FichaTecnicaModel model)
        {
            return View(model);
        }

        public ActionResult Sobre(SobreModel model)
        {
            return View(model);
        }
    }   
}