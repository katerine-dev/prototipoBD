-- criando Bando de dados 
CREATE DATABASE BIBLIOTECA;
-- acessando banco de dados criado
USE BIBLIOTECA;
/* Criar tabela categoria: 
cógigo categoria será uma chave primária,
ela servirá de referência para outras tabelas
- para manter integridade referencial
e a garantia de consistência dos dados
entre as tabelas 'categoria' e 'livros' decidimos utilizar 
a chave estrangeira para atribuir as categorias. 
*/
CREATE TABLE categoria (
cod_categoria INT AUTO_INCREMENT PRIMARY KEY,
nome_categoria VARCHAR(30)
);

-- Criar tabela Livros: 
CREATE TABLE livros (
  cod_livro INT AUTO_INCREMENT PRIMARY KEY,
  nome_livro VARCHAR(30),
  autor_livro VARCHAR(30)
);
/* 
Tabela associativa = existe para implementar uma relação n:n
Quais são as categorias de um livro: 
*/ 
CREATE TABLE livrosCategoria (
	cod_livro INT NOT NULL,
	cod_categoria INT NOT NULL,
	FOREIGN KEY (cod_categoria) REFERENCES categoria(cod_categoria),
	FOREIGN KEY (cod_livro) REFERENCES livros(cod_livro)
);
-- criar tabela usuario
CREATE TABLE leitor (
nome_usuario VARCHAR(255),
ra_usuario LONG,
cpf_usuario VARCHAR(11)
);

-- criar tabela bibliotecaria

CREATE TABLE bibliotecaria (
nome_bibliotecaria VARCHAR(255),
cpf_bibliotecaria VARCHAR(11)
);

-- criar tabela historico
CREATE TABLE emprestimo (
cod_livro INT NOT NULL,
nome_livro VARCHAR(30),
autor_livro VARCHAR(30),
status_livro VARCHAR(30),
nome_usuario VARCHAR(30)
);

-- criar tabela usuarioEmprestimo
/*
solicitado criar index para tabela usuario, 
criado idx_usuario_ra_usuario
*/
CREATE TABLE usuarioEmprestimo (
cod_livro INT NOT NULL,
ra_usuario INT NOT NULL, 
FOREIGN KEY (cod_livro) REFERENCES livros(cod_livro),
FOREIGN KEY (ra_usuario) REFERENCES usuario(ra_usuario)
);

-- renomear tabelas usuario e usuarioEmprestimo
USE biblioteca;

RENAME TABLE usuario TO leitor; 
RENAME TABLE usuarioEmprestimo TO leitorEmprestimo;