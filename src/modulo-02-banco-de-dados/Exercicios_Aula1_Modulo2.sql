select *
into CidadeAux
from Cidade

truncate table CidadeAux;

insert into CidadeAux (IDCidade, Nome, UF)
select IDCidade, Nome, UF
from Cidade;

create table Produto
(
	IDProduto	int identity	not null,
	Nome		varchar(20)		not null,
	Descricao	varchar(60)		not null,
	DataCriacao datetime		default getdate() not null,
	LocalEstoque varchar(30)	not null,
	Quantidade	decimal(7,3)	not null, -- valor maximo: 9999.999
	Preco		decimal(7,2)	not null, -- valor maximo: 99999,99
		constraint PK_Produto primary key (IDProduto)
);

insert into Produto (Nome, Descricao, LocalEstoque, Quantidade, Preco)
	values ('Alcatra', 'Carne Bovina Alcatra Kg', 'Açougue do Jorge', 1.0, 25.00);
	
insert into Produto (Nome, Descricao, LocalEstoque, Quantidade, Preco)
	values ('Heineken Long Neck', 'Long Neck Cerveja Heineken', 'Bar', 1, 5.00);