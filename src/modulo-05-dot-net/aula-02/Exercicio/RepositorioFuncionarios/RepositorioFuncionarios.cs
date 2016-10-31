﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(funcionario => funcionario.Cargo.Equals(cargo)).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ThenBy(f=>f.Nome).ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.Where(funcionario => 
                funcionario.Nome.IndexOf(nome, StringComparison.OrdinalIgnoreCase)>=0).ToList();
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            if (turnos.Length == 0)
            {
                return Funcionarios;
            }
            return Funcionarios.Where(funcionario => turnos.Contains(funcionario.TurnoTrabalho)).ToList();
        }        

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            int idadeMinima = idade - 5;
            int idadeMaxima = idade + 5;
            var hoje = DateTime.Now;
            Func<Funcionario, bool> myFunc = funcionario => 
                    (hoje.Year - funcionario.DataNascimento.Year) >= idadeMinima &&
                    (hoje.Year - funcionario.DataNascimento.Year) <= idadeMaxima;
            return Funcionarios.Where(myFunc).ToList();
        }        

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            if (turno == null)
            {
                return Funcionarios.Select(fun => fun.Cargo.Salario).Average();
            }
            else
            {
                return Funcionarios.Where(fun => 
                        fun.TurnoTrabalho.Equals(turno)).Select(fun =>
                            fun.Cargo.Salario).Average();
            }
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var mesAtual = DateTime.Now.Month;
            return Funcionarios.Where(fun => fun.DataNascimento.Month.Equals(mesAtual)).ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
            var listaFuncionarios = new List<Object>();
            foreach (Funcionario f in Funcionarios)
            {
                var item = new { NomeFuncionario = f.Nome, TituloCargo = f.Cargo.Titulo };
                listaFuncionarios.Add(item);
            }
            return listaFuncionarios;
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            var resultado = new List<Object>();
            var listaTurnos = Funcionarios.Select(f => f.TurnoTrabalho).Distinct();
            foreach (TurnoTrabalho turno in listaTurnos)
            {
                int quantidade = Funcionarios.Where(f => f.TurnoTrabalho.Equals(turno)).Count();
                var item = new { Turno = turno, Quantidade = quantidade };
                resultado.Add(item);
            }
            return resultado;
        }

        public dynamic FuncionarioMaisComplexo()
        {
            var listaFuncionarios = Funcionarios.Where(f => !f.Cargo.Titulo.Equals("Desenvolvedor Júnior"))
                            .Where(f => !f.TurnoTrabalho.Equals(TurnoTrabalho.Tarde));

            Funcionario funcionario = listaFuncionarios.OrderBy(f => ContarConsoantes(f.Nome)).Last();

            int quantidadeMesmoCargo = Funcionarios.Where(f => f.Cargo.Titulo.Equals(funcionario.Cargo.Titulo)).Count();
            var salarioRS = FormatarStringMoeda("pt-BR", funcionario.Cargo.Salario);
            var salarioUS = FormatarStringMoeda("en-US", funcionario.Cargo.Salario);

            return new { Nome = funcionario.Nome,
                         DataNascimento = funcionario.DataNascimento.ToShortDateString(),
                         SalarioRS = salarioRS,
                         SalarioUS = salarioUS,
                         QuantidadeMesmoCargo = quantidadeMesmoCargo
            };
        }

        private string FormatarStringMoeda(string cultura, double valor)
        {
            return string.Format(CultureInfo.GetCultureInfo(cultura), "{0:C}", valor);
        }

        private int ContarConsoantes(String palavra)
        {
            int contagem = 0;
            string consoantes = "bcdfghjklmnpqrstvwxz";
            foreach(char c in palavra.ToLower())
            {
                if (consoantes.IndexOf(c) >= 0)
                    contagem++;
            }
            return contagem;
        }
    }
}
