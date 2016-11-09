using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        Produto BuscarPorId(int id);
        List<Produto> BuscarProdutos(string filtroNome);
    }
}
