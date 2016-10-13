
-- ex 1

select NomeEmpregado, datediff(Month, DataAdmissao, convert(datetime,'31/12/2000',103)) as TotalMesesDeTrabalho
from Empregado
where convert(datetime,DataAdmissao,103) >= '01/05/1980' and convert(datetime,DataAdmissao,103) <= '01/05/1982';


-- ex 2

select max(Cargo) as CargoComMaisEmpregados
from Empregado;

Select Cargo, COUNT(1) as TotalEmpregados, COUNT(Distinct Cargo) as TotalCargos 
From Empregado
group by cargo


-- ex 3

select UF, count(1) as Cidades
from Cidade
group by uf


-- ex 4
select c.Nome
from Cidade c
inner join Cidade d
	on c.UF = d.UF




