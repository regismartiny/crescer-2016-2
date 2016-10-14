-- ex 1

select count(*) 
from Pedido
where DataPedido between convert(datetime,'01/09/2016',103) and convert(datetime,'30/09/2016',103);


-- ex 2

select Nome
from Produto p
inner join ProdutoMaterial pm on pm.IDProduto = p.IDProduto
where pm.IDMaterial = 15836;


-- ex 3

select IDCliente, Nome, RazaoSocial
from Cliente
where Nome like '%LTDA' or RazaoSocial like '%LTDA';


-- ex 4

insert 
	into Produto(Nome,PrecoCusto,PrecoVenda,Situacao) 
	values('Galocha Maragato',35.67,77.95,'A');


-- ex 5

select distinct Nome as Produto_Sem_Pedidos
	from Produto
	where IDProduto not in (select p.IDProduto
								from Produto p
								inner join PedidoItem pei on p.IDProduto = pei.IDproduto
								inner join Pedido pe on pei.IDPedido = pe.IDPedido);


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


-- ex 8


