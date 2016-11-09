using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }

        public Produto BuscarPorId(int id)
        {
            Produto produtoEncontrado = this.produtoRepositorio.BuscarPorId(id);

            if(produtoEncontrado != null)
            {
                return produtoEncontrado;
            }

            return null;
        }

        public List<Produto> BuscarProdutos(string filtroNome)
        {
            return this.produtoRepositorio.BuscarProdutos(filtroNome);
        }
    }
}
