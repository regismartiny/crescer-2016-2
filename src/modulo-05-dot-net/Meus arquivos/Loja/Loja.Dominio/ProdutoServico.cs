using Loja.Dominio.Exceptions;
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

        public Produto BuscarPorNome(string nome)
        {
            Produto produtoEncontrado = this.produtoRepositorio.BuscarPorNome(nome);

            if (produtoEncontrado != null)
            {
                return produtoEncontrado;
            }

            return null;
        }

        public List<Produto> BuscarProdutos(string filtroNome)
        {
            return this.produtoRepositorio.Buscar(filtroNome);
        }

        public void Validar(Produto produto)
        {
            Produto produtoEncontrado = this.BuscarPorNome(produto.Nome);
            if (produtoEncontrado != null && produto.Id != produtoEncontrado.Id)
                throw new NomeRepetidoException();
        }

        public void Salvar(Produto produto)
        {
            this.produtoRepositorio.Salvar(produto);
        }

        public void ExcluirPorId(int id)
        {
            this.produtoRepositorio.ExcluirPorId(id);
        }
    }
}
