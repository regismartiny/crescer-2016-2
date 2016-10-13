-- Resposta 1

select empregado, count(1) as TotalParticipacoesProjeto
from Projeto
group by Empregado
having count(1) > 1;


-- Resposta 2

select distinct Projeto
from Projeto
where ValorFaturado>ValorRealizado;

-- Resposta 3

select distinct Projeto
from Projeto
where ValorFaturado<ValorRealizado;


-- Resposta 4

select Empregado,
LEFT(Empregado,CHARINDEX(' ',Empregado + ' ')) AS PrimeiroNome
from Projeto
group by Empregado;
