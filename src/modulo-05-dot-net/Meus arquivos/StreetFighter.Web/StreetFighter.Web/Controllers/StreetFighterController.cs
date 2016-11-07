using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
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
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult ListaPersonagens(string filtro)
        {
            var aplicativo = new PersonagemAplicativo();
            var personagens = aplicativo.ListarPersonagensBanco(filtro);
            return View(personagens);
        }

        [HttpGet]
        public ActionResult Cadastro()
        {
            PopularPaises();
            return View();
        }

        [HttpGet]
        public ActionResult ExclusaoPersonagem(string id)
        {
            var aplicativo = new PersonagemAplicativo();
            try
            {
                bool ok = aplicativo.ExcluirPersonagem(id);
                if (ok)
                    ViewBag.Mensagem = "Personagem excluído com sucesso";
            }
            catch
            {
                ModelState.AddModelError("", "Ocorreu um erro inesperado. Contate o administrador do sistema.");
            }
            var personagens = aplicativo.ListarPersonagens("");
            return View("ListaPersonagens", personagens);
        }

        [HttpGet]
        public ActionResult EdicaoPersonagem(string id)
        {
            var personagemAplicativo = new PersonagemAplicativo();
            Personagem personagem = personagemAplicativo.ObterPersonagemBanco(id);
            FichaTecnicaModel model = new FichaTecnicaModel
            {
                Id = personagem.Id,
                Imagem = personagem.Imagem,
                Nome = personagem.Nome,
                DataNascimento = personagem.DataNascimento,
                Altura = personagem.Altura,
                Peso = personagem.Peso,
                Origem = personagem.Origem,
                GolpesEspeciais = personagem.GolpesEspeciais,
                PersonagemOculto = personagem.PersonagemOculto
            };
            PopularPaises();
            return View("Cadastro", model);
        }

        [HttpPost]
        public ActionResult Salvar(FichaTecnicaModel model)
        {
            PopularPaises();

            if (ModelState.IsValid)
            {
                try
                {
                    var aplicativo = new PersonagemAplicativo();
                    var personagem = new Personagem(model.Imagem, model.Nome, model.DataNascimento,
                        model.Altura, model.Peso, model.Origem, model.GolpesEspeciais, model.PersonagemOculto);

                    aplicativo.Salvar(personagem);

                    ViewBag.Mensagem = "Cadastro concluído com sucesso.";
                    return View("FichaTecnica", model);
                }
                catch (RegraNegocioException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                catch
                {
                    ModelState.AddModelError("", "Ocorreu um erro inesperado. Contate o administrador do sistema.");
                }
                return View("Cadastro");
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro.");
                return View("Cadastro");
            }
        }

        [HttpGet]
        public ActionResult FichaTecnica(FichaTecnicaModel model)
        {
            return View(model);
        }

        [HttpGet]
        public ActionResult Sobre(SobreModel model)
        {
            return View(model);
        }


        private void PopularPaises()
        {
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