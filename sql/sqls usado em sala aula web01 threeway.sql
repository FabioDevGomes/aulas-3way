﻿-- Database: threeway (alteração nova branch)

-- DROP DATABASE threeway;

CREATE DATABASE threeway
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;


       CREATE TABLE cliente (
COD_CLIENTE SERIAL NOT NULL,
	NOME VARCHAR(50) NOT NULL,
	LOGIN VARCHAR(10) NOT NULL,
	SENHA VARCHAR(10) NOT NULL,
	ENDERECO VARCHAR(32) NOT NULL,
	CIDADE VARCHAR(32) NOT NULL,
	BAIRRO VARCHAR(32) NOT NULL,
	ESTADO VARCHAR(32) NOT NULL,
	CEP VARCHAR(10) NOT NULL,
	PRIMARY KEY (COD_CLIENTE)
	);

CREATE TABLE livro (
	COD_LIVRO SERIAL NOT NULL,
	TITULO VARCHAR(50) NOT NULL,
	AUTOR VARCHAR(50) NOT NULL,
	PRECO NUMERIC NOT NULL,
	IMAGEM VARCHAR(100),
	DESCRICAO VARCHAR(100),
	PRIMARY KEY (COD_LIVRO)
	);


INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('GRANDE SERTAO - VEREDAS','ROSA, JOAO GUIMARAES', 165, 'imagens/veredas.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('QUANDO NIETZSCHE CHOROU','YALOM, IRVIN D.', 49.9, 'imagens/chorou.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('CASSINO ROYALE - JAMES BOND 00', 'Fleming, Ian', 29.9, 'imagens/james.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('FILOSOFIA DO TEDIO','Svendsen, Lars', 29.9, 'imagens/tedio.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('O CASAMENTO', 'Rodrigues, Nelson', 39.9, 'imagens/casamento.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('NEVE', 'PAMUK, ORHAN', 54,'imagens/neve.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('VOLTA AO MUNDO EM OITENTA DIAS', 'VERNE, JULIO', 16.5, 'imagens/volta_mundo.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('CRISTOVAO COLOMBO','VERNE, JULIO', 16.5, 'imagens/cristovao_colombo.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('VINTE MIL LEGUAS SUBMARINAS', 'VERNE, JULIO', 14.9, 'imagens/submarinas.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('O SENHOR DOS ANEIS', 'TOLKIEN, J.R.R.', 169.9, 'imagens/senhor.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('HARRY POTTER', 'ROWLING, J.K.', 89.7, 'imagens/harry.png');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('A AVENTURAS DE PI', 'MARTEL, YANN', 23.5, 'imagens/lifeofpi.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('PARA ONDE ELA FOI?','FORMAN, GAYLE', 20.0, 'imagens/onde.jpg');
INSERT INTO livro (TITULO,AUTOR,PRECO,IMAGEM) VALUES ('O LIVRO DO CEMITERIO','GAILMAN, NEIL', 20.0, 'imagens/cemiterio.jpg');


select * from livro;

