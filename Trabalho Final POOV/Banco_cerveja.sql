create database fabrica;

create table cliente(
cpf varchar(14),
nome varchar(30),
telefone varchar(30),
endereco varchar(50),
insta varchar(30),
primary key(cpf)
);

create table cerveja(
idBeer varchar(30),
descricao varchar(30),
valor double,
primary key (idBeer)
);

create table pedidos(
id_cerveja_pedido varchar(30),
id_pedido varchar(30),
fk_cpf_cliente varchar(14),
fk_id_cerveja varchar(30),
quantidade integer not null,
data_pedido date,
primary key(id_cerveja_pedido, id_pedido),
foreign key(fk_cpf_cliente) references cliente(cpf),
foreign key(fk_id_cerveja) references cerveja(idBeer)
);

insert into cliente values('127.202.366-40','Luís Filipi','(34)99142-9039', 'Rua Travessa José, 50','@luisinfilipi');
insert into cliente values('344.202.377-66','Alek Fumasa','(34)99169-2469', 'Rua Castelo Xesque, 69','@alekfumasa');
insert into cliente values('019.322.213-55','Emerson Olhos','(34)99269-9669', 'Rua Castelo Xesque, 96','@eversonzoio');  

insert into cerveja values('01','Skol', 2.0);
insert into cerveja values('02','Devassa', 2.50);
insert into cerveja values('03','Brahma', 2.0);

