SELECT * FROM usuario;
-- para vizualizar usuarioEmprestimo
SELECT ue.cod_livro, e.nome_livro, e.autor_livro, e.status_livro, ue.ra_usuario, u.nome_usuario
FROM livrosCategoria ue
JOIN emprestimo e ON ue.cod_livro = e.cod_livro
JOIN categoria c ON ue.ra_usuario = u.ra_usuario;