﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions
{
    public class ValorZeradoException : RegraNegocioException
    {
        public ValorZeradoException() : base("Valor do produto não pode ser zero.")
        {
        }
    }
}
