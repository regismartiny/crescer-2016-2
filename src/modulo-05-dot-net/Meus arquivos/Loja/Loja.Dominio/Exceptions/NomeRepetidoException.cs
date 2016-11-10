using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions
{
    public class NomeRepetidoException : RegraNegocioException
    {
        public NomeRepetidoException() : base("Já existe um produto com esse nome.")
        {
        }
    }
}
