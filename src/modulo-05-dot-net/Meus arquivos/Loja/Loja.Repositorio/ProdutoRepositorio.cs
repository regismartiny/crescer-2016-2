using Loja.Repositorio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
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

        public List<Produto> Buscar(string filtroNome)
        {
            using (var context = new ContextoDeDados())
            {
                if (String.IsNullOrEmpty(filtroNome))
                    return context.Produto.ToList();
                else
                    return context.Produto.Where(p => p.Nome.Contains(filtroNome)).ToList();
            }
        }

        public Produto BuscarPorNome(string nome)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.FirstOrDefault(p => p.Nome.Equals(nome));
            }
        }

        public void Salvar(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                EntityState state;
                if (produto.Id == 0)
                    state = EntityState.Added;
                else
                    state = EntityState.Modified;
                context.Entry<Produto>(produto).State = state;
                context.SaveChanges();
            }
        }

        public void ExcluirPorId(int id)
        {
            using (var context = new ContextoDeDados())
            {
                Produto produto = context.Produto.FirstOrDefault(p => p.Id.Equals(id));
                context.Entry<Produto>(produto).State = EntityState.Deleted;
                context.SaveChanges();
            }

        }
    }
}
