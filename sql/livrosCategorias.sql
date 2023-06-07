-- Tabela LIVROS e lIVROS E CATEGORIA
-- Para criar um livro novo no sistema precisa utilizar o método livroDb.criarLivros()
-- respeitando a relação entre as tabelas e o autoincremt dos cod_livro e cod_categoria

-- para visualizar tabela livros

SELECT * FROM livros;

-- contar a quantidade de linhas em livrosCategoria

SELECT count(*) FROM livrosCategoria;

-- Para visualizar livroCategoria
SELECT lc.cod_livro, l.nome_livro, l.autor_livro, lc.cod_categoria, c.nome_categoria
FROM livrosCategoria lc 
JOIN livros l ON lc.cod_livro = l.cod_livro
JOIN categoria c ON lc.cod_categoria = c.cod_categoria;

