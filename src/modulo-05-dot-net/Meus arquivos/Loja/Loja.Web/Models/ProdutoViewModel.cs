using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ProdutoViewModel
    {
        public ProdutoViewModel() { }

        public int? Id { get; set; }

        [Required(ErrorMessage = "O Nome é obrigatório.")]
        [DisplayName("Nome")]
        public String Nome { get; set; }

        [Required(ErrorMessage = "O Valor é obrigatório.")]
        [DisplayName("Valor")]
        public decimal Valor { get; set; }
    }

    public static class ProdutoViewModelExtensions
    {
        public static ProdutoViewModel ConverterParaViewModel(this Produto produto)
        {
            return new ProdutoViewModel()
            {
                Nome = produto.Nome,
                Valor = produto.Valor
            };

        }
    }
}