-- Tabela Livros e livrosCategoria

-- Para visualizar livroCategoria
SELECT lc.cod_livro, l.nome_livro, l.autor_livro, lc.cod_categoria, c.nome_categoria
FROM livrosCategoria lc 
JOIN livros l ON lc.cod_livro = l.cod_livro
JOIN categoria c ON lc.cod_categoria = c.cod_categoria;

