-- criando Bando de dados 
CREATE DATABASE BIBLIOTECA;
-- acessando banco de dados criado
USE BIBLIOTECA;
-- criar tabela livros
CREATE TABLE livros (
cod_livro INT NOT NULL PRIMARY KEY,
nome_livro TEXT,
autor_livro TEXT,
categoria_livro INT
);
-- criar tabela usuario
CREATE TABLE usuario (
nome_usuario TEXT,
ra_usuario INT
);
-- criar tabela livros
CREATE TABLE categorias (
cod_categoria INT NOT NULL PRIMARY KEY,
nome_categoria TEXT
);
-- criar tabela historico
CREATE TABLE historico (
cod_livro INT NOT NULL,
nome_livro TEXT,
autor_livro TEXT,
status_livro TEXT,
nome_usuario TEXT
);