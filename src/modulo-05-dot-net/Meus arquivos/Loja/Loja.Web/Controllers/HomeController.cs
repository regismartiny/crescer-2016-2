using Loja.Dominio;
using Loja.Dominio.Exceptions;
using Loja.Web.Filters;
using Loja.Web.Models;
using System;
using System.Collections.Generic;
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

        [HttpGet]
        public ActionResult CadastroEdicaoProduto(int? id)
        {
            ProdutoViewModel model;
            if (id == null)
                model = new ProdutoViewModel();
            else
            {
                var servico = new ProdutoServico(new ProdutoRepositorio());
                Produto produto = servico.BuscarPorId(Convert.ToInt32(id));
                model = produto.ConverterParaViewModel();
            }
            return View("CadastroEdicaoProduto", model);
        }

        [HttpPost]
        public ActionResult Salvar(ProdutoViewModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    var servico = new ProdutoServico(new ProdutoRepositorio());
                    Produto produto = new Produto(Convert.ToInt32(model.Id), model.Nome, model.Valor);

                    servico.Validar(produto);

                    servico.Salvar(produto);

                    if (produto.Id == 0)
                        ViewBag.Mensagem = "Cadastro concluído com sucesso.";
                    else
                        ViewBag.Mensagem = "Cadastro atualizado com sucesso.";

                    return View("FichaTecnica", model);
                }
                catch(RegraNegocioException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                catch
                {
                    ModelState.AddModelError("", "Ocorreu um erro inesperado. Contate o administrador do sistema.");
                }
                return View("CadastroEdicaoProduto");
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro.");
                return View("CadastroEdicaoProduto");
            }
        }

        [HttpGet]
        public ActionResult ExclusaoProduto(int id)
        {
            var servico = new ProdutoServico(new ProdutoRepositorio());
            servico.ExcluirPorId(id);
            return RedirectToAction("Index");
        }

        [HttpGet]
        public ActionResult FichaTecnica(int id)
        {
            var servico = new ProdutoServico(new ProdutoRepositorio());
            Produto produto = servico.BuscarPorId(id);
            ProdutoViewModel model = new ProdutoViewModel
            {
                Id = produto.Id,
                Nome = produto.Nome,
                Valor = produto.Valor
            };
            return View("FichaTecnica", model);
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