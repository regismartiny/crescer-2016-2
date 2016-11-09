using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEntityFramework
{
    public class PersonagemRepositorioEF
    {
        public Personagem GetPersonagemByID(int id)
        {
            using (var context = new DatabaseContext())
            {
                Personagem personagemfound = context.Personagem.Find(id);
                return personagemfound;
            }
        }

        public List<Personagem> GetPersonagens(string filtroNome)
        {
            List<Personagem> encontrados = new List<Personagem>();
            using (var context = new DatabaseContext())
            {
                if (!String.IsNullOrEmpty(filtroNome))
                    encontrados = context.Personagem.Where(p => p.Nome.Contains(filtroNome)).ToList();
                else
                    encontrados = context.Personagem.ToList();
                return encontrados;
            }

        }

        public void SalvarPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Added;
                context.SaveChanges();
            }
        }
    }
}
