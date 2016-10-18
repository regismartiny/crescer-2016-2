-- ex 1

select count(*) 
from Pedido
where DataPedido between convert(datetime,'01/09/2016',103) and convert(datetime,'30/09/2016',103)+.99999;

-- 1.0 = 1 dia(24h)
-- 0.99999 = 23h:59m:59s


-- ex 2

select IDProduto
from ProdutoMaterial
where IDMaterial = 15836;

--ou

select p.IDProduto, Nome
from Produto p
inner join ProdutoMaterial pm on pm.IDProduto = p.IDProduto
where pm.IDMaterial = 15836;

--ou

select p.IDProduto, Nome
from Produto p
where exists (select 1
			  from ProdutoMaterial pm
			  where pm.IDProduto = p.IDproduto
			  and pm.IDMaterial = 15836);



begin transaction
--criação de índice
create index IX_ProdutoMaterial_Material on ProdutoMaterial (IDMaterial);

--índice composto
-- criar quando ambas as colunas são utilizadas como filtro
selec IDprodutoMaterial, IDProduto
from ProdutoMaterial PM
where pm.IDMateria = 15836
and pm.IDproduto

create index IX_ProdutoMaterial_MaterialProduto on ProdutoMaterial (IDMaterial,IDProduto);

rollback

-- ex 3

select IDCliente, Nome, RazaoSocial
from Cliente
where Nome like '%LTDA%' or RazaoSocial like '%LTDA%';


-- ex 4

insert 
	into Produto(Nome,PrecoCusto,PrecoVenda,Situacao) 
	values('Galocha Maragato',35.67,77.95,'A');


-- ex 5

select Nome as Produto_Sem_Pedidos
	from Produto
	where IDProduto not in (select p.IDProduto
								from Produto p
								inner join PedidoItem pei on p.IDProduto = pei.IDproduto
								inner join Pedido pe on pei.IDPedido = pe.IDPedido);

--ou

select IDProduto, Nome
From Produto pro
Where IDproduto not in (Select IDproduto From PedidoItem item);

--com not exists     mais performatico(principalmente se criar indice)
select Nome as Produto_Sem_Pedidos
	from Produto p
	where not exists (select 1
					  from PedidoItem i
					  where p.IDProduto = i.IDproduto);


-- ex 6

select (select UF 
	from Cidade c
	where c.IDCidade = (select max(ci.IDCidade) 
						from Cidade ci
						inner join Cliente cli on cli.IDCidade = ci.IDCidade)) as UF_Maior_N_Clientes,
		(select UF 
	from Cidade c
	where c.IDCidade = (select min(ci.IDCidade) 
						from Cidade ci
						inner join Cliente cli on cli.IDCidade = ci.IDCidade)) as UF_Menor_N_Clientes;


--teste: select UF, count(*) from Cidade group by UF having UF = 'AL'
--teste: select UF, count(*) from Cidade group by UF having UF = 'SP'


-- ex 7

select p.IDPedido, p.DataEntrega, p.ValorPedido, (select count(1) from PedidoItem pedi where pedi.IDPedido = p.IDPedido) as Quant_Itens, c.Nome as Cliente
	from Pedido p
	inner join PedidoItem pei on pei.IDPedido = p.IDPedido
	inner join ProdutoMaterial pm on pei.IDProduto = pm.IDProduto
	inner join Cliente c on p.IDCliente = c.IDCliente
	where pm.IDMaterial in (14650,15703,15836,16003,16604,17226)
		and p.DataEntrega between convert(datetime,'01/10/2016',103) 
							and convert(datetime,'30/10/2016',103);






