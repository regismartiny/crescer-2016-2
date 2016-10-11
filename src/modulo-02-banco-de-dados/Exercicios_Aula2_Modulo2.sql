select NomeEmpregado 
from Empregado 
order by DataAdmissao;

select NomeEmpregado, Salario as SalarioMensal, Salario*12 as SalarioAnual 
from Empregado 
where Cargo = 'ATENDENTE' AND Salario*12 < 18500;

select IDCidade 
from Cidade 
where Nome = 'Uberlândia';

select IDCidade, Nome 
from Cidade 
where UF = 'RS';