-- Interações com a tabela Categorias 
-- Testes para interações com Java
USE BIBLIOTECA;

-- Inserir novas informações
INSERT INTO categorias (nome_categoria) VALUES ("Romance");

-- Alterar informações
UPDATE categorias SET nome_categoria = "Suspense"
 WHERE cod_categoria = 1;


-- Visualizar
SELECT * FROM categorias;