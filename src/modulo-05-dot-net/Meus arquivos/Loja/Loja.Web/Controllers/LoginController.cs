using Loja.Dominio;
using Loja.Infraestrutura;
using Loja.Repositorio;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(UsuarioModel model)
        {
            UsuarioServico usuarioServico = ServicoDeDependencias.MontarUsuarioServico();

            Usuario usuarioAutenticado = usuarioServico.BuscarPorAutenticacao(model.Email, model.Senha);

            if (usuarioAutenticado != null)
            {
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(
                    usuarioAutenticado.Email/*,usuarioAutenticado.Permissoes*/));
                return RedirectToAction("Index", "Home");
            }else
            {
                ViewBag.Mensagem = "Erro de login.";
                return View("Index");
            }
        }
    }
}