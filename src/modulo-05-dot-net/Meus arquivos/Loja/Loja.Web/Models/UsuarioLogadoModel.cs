using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class UsuarioLogadoModel
    {
        public UsuarioLogadoModel(string email, string[] permissoes = null)
        {
            this.Email = email;
            //this.Permissoes = permissoes;
        }

        public string Email { get; private set; }
        //public string[] Permissoes { get; private set; }
    }
}