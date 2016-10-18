
-- ex 1

select NomeEmpregado, 
	datediff(Month, DataAdmissao, convert(datetime,'31/12/2000',103)) as Total_Meses_De_Trabalho
from Empregado
where convert(datetime,DataAdmissao,103) >= '01/05/1980' and convert(datetime,DataAdmissao,103) <= '01/05/1982';

--ou

select NomeEmpregado, DataAdmissao,
	datediff(Month, DataAdmissao, convert(datetime,'31/12/2000',103)) as Total_Meses_De_Trabalho
from Empregado
where DataAdmissao between convert(datetime,'01/05/1980',103) 
						and convert(datetime,'20/01/1982',103);



-- ex 2

select top 1 WITH TIES 
	Cargo, 
	count(1) as Total_Empregados
from Empregado
group by Cargo
order by Total_Empregados desc;


-- ex 3

select UF, count(1) as Cidades
from Cidade
group by UF


-- ex 4

select Nome, UF
from Cidade
group by Nome, UF
having count(1) > 1


-- ex 5

select isnull(max(IDAssociado),0)+1 as Proximo_ID
from Associado


-- ex 6

select NomeEmpregado, Salario,
	case when Salario <= 1164 then '0%'
		 when Salario <= 2326 then '15%'
		 else '27,5%'
	End Percentual_Desconto_IR
from Empregado


-- ex 7

select emp.NomeEmpregado, 
	ger.NomeEmpregado as Nome_Gerente, 
	de.NomeDepartamento as Departamento_Empregado, 
	dg.NomeDepartamento as Departamento_Gerente
from Empregado emp
left join Empregado ger
	on emp.IDGerente = ger.IDEmpregado
left join Departamento de
	on de.IDDepartamento = emp.IDDepartamento
left join Departamento dg
	on dg.IDDepartamento = ger.IDDepartamento


-- ex 8
select *
into Empregado_copia
from Empregado

begin transaction

update Empregado_copia
set Salario = Salario * 1.145
where exists (select 1 
			  from Departamento d
			  where d.IDDepartamento = Empregado_copia.IDDepartamento
			  and d.Localizacao = 'sao paulo');
rollback


-- ex 9

select sum(e.Salario) as Antes_Reajuste, 
		sum(ec.Salario) as Depois_Reajuste, 
		sum(ec.Salario)-sum(e.Salario) as Diferenca
from Empregado_copia ec
inner join Empregado e on ec.IDEmpregado = e.IDEmpregado;



-- ex 10

Select IDDepartamento, NomeDepartamento
From   Departamento dep
Where  exists (select 1
               from   Empregado emp
			   Where  emp.IDDepartamento = dep.IDDepartamento
			   and    emp.Salario        = (select max(Salario)
			                                from   empregado
											where  IDDepartamento is not null) -- prevendo que o departamento seja informado
			   );

--ou     //solução menos performática, devido ao uso do distinct

Select distinct dep.IDDepartamento, dep.NomeDepartamento
From   Departamento dep
inner join Empregado emp on emp.IDDepartamento = dep.IDDepartamento
Where  emp.Salario = (select max(Salario)
			          from   empregado
					  where  IDDepartamento is not null); -- prevendo que o departamento seja informado

