-- Feito por Matheus Santana
-- criando database e usando-a
create database players;
use players;
-- criando a tabela
create table stats(
id bigint primary key auto_increment, -- a chave primaria para a tabela é o ID que se auto incrementa a cada dado inserido
nome varchar(100) not null,
clube varchar(30),
posicao varchar(15) not null,
gols int,
assistencias int,
cartoes_amarelos int,
cartoes_vermelhos int
); 
-- como podem perceber, as unicas colunas que são not null (ou seja, não pode ser nulo) além da primary key, são o Nome e Posição, 
-- pois para existir um 'jogador' precisa de nome e posição do mesmo, o restante pode ser nulo
