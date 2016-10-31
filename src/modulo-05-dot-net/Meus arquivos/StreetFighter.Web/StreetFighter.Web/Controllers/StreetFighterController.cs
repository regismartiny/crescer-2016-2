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

        public ActionResult FichaTecnica()
        {
            var model = new FichaTecnicaModel();

            return View(model);
        }

        public ActionResult Sobre()
        {
            var model = new SobreModel();

            return View(model);
        }
    }   
}