using Loja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public Produto BuscarPorId(int id)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.FirstOrDefault(p => p.Id.Equals(id));
            }
        }

        public List<Produto> BuscarProdutos(string filtroNome)
        {
            List<Produto> lista = new List<Produto>();
            lista.Add(new Produto
            {
                Nome = "ProdutoTeste",
                Valor = 100
            });
            return lista;
        }
    }
}
