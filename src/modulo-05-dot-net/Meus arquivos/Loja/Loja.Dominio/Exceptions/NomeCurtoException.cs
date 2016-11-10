using Loja.Dominio.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class NomeCurtoException : RegraNegocioException
    {
        public NomeCurtoException() : base("Nome do produto deve ter no mínimo dois caracteres.")
        {
        }
    }
}
