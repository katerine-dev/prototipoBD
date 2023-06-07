-- Bibliotecaria
SELECT * FROM bibliotecaria;

-- Interações com a tabela Bibliotecaria
-- Testes para interações com Java 
-- Inserir mais informações 
INSERT INTO bibliotecaria (nome_bibliotecaria, cpf_bibliotecaria, email_bibliotecaria)  
VALUES ('Maria Santos', '76567898719', 'maria@email.com'),
		('João Silva', '76524361789', 'joao@email.com');
-- Teste dois
INSERT INTO bibliotecaria (nome_bibliotecaria, cpf_bibliotecaria, email_bibliotecaria)
VALUES ('teste teste', '64728728902', 'teste@email.com');


-- desativar temporariamente o modo de atualização segura na sessão atual
SET SQL_SAFE_UPDATES = 0;
-- Alterar informações
UPDATE bibliotecaria
SET nome_bibliotecaria = 'Teste teste'
WHERE cpf_bibliotecaria = '64728728902';


-- Para contar as linhas da tabela categoria
SELECT count(*) FROM bibliotecaria;

-- Para deletar alguma categoria

DELETE FROM bibliotecaria
WHERE cpf_bibliotecaria = '64728728902';