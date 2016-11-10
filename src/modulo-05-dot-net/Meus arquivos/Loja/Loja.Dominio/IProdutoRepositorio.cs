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
        Produto BuscarPorNome(string nome);
        List<Produto> Buscar(string filtroNome);
        void Salvar(Produto produto);
        void ExcluirPorId(int id);
    }
}
