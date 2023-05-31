-- TABELA EMPRESTIMO E LEITOR EMPRESTIMO
-- A tabela leitorEmprestimo é reponsável pelo histório de empretimo e devolução de livros

-- para vizualizar leitorEmprestimo
SELECT lc.cod_livro, le.status_livro, l.ra_leitor
FROM leitorEmprestimo le
JOIN livrosCategoria lc ON le.cod_livro = lc.cod_livro
JOIN leitor l ON le.ra_leitor = l.ra_leitor;