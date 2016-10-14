
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

select B.NomeEmpregado, 
	A.NomeEmpregado as NomeGerente, 
	C.NomeDepartamento as Departamento_Empregado, 
	D.NomeDepartamento as Departamento_Gerente
from Empregado A
inner join Empregado B
	on A.IDEmpregado = B.IDGerente
inner join Departamento C
	on A.IDDepartamento = C.IDDepartamento
inner join Departamento D
	on C.IDDepartamento = D.IDDepartamento


-- ex 8
drop Empregado_copia;

select *
into Empregado_copia
from Empregado;

update Empregado_copia 
set Salario=Salario*1.145
where IDDepartamento IN (select IDDepartamento from Departamento where Localizacao = 'SAO PAULO');


-- ex 9

select (select sum(salario) from Empregado_copia) - sum(Salario) As Diferenca_Apos_Reajuste
from Empregado


-- ex 10

select IDDepartamento, Salario
from Empregado
where Salario = (select max(Salario) from Empregado);

