using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class UsuarioViewModel
    {
        [Required(ErrorMessage = "O Email é obrigatório.")]
        [DisplayName("Email")]
        public string Email { get; set; }

        [Required(ErrorMessage = "A Senha é obrigatória.")]
        [DisplayName("Senha")]
        public String Senha { get; set; }
    }
}