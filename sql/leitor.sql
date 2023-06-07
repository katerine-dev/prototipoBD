-- TABELA LEITOR

-- Interações com a tabela leitor

SELECT * FROM leitor;

-- Jenni precisa criar interação com UPDATE e DELETE. 

INSERT INTO leitor (nome_leitor, ra_leitor, email_leitor) 
VALUES ('Eduarda Fernandes', '12345678910', 'eduarda@email.com'),
		('Jennifer Souza ', '09876543211', 'jennifer@email.com'),
		('Katerine Witkoski', '23456765678', 'katerine@email.com'),
		('Nathalie Zampieri ', '3456789020', 'nathalie@email.com'),
		('Thifany Santos', '34187590293', 'thifany@email.com');


-- Interações com a tabela Leitor
-- Testes para interações com Java 
-- Inserir mais informações 
INSERT INTO leitor (nome_leitor, ra_leitor, email_leitor)  
VALUES ('Sérgio Santos', '98763546789', 'sergio@email.com');
-- Teste dois
INSERT INTO leitor (nome_leitor, ra_leitor, email_leitor)  
VALUES ('teste teste', '64728728902', 'teste@email.com');

-- Alterar informações
UPDATE leitor SET nome_leitor = 'Teste teste'
 WHERE ra_leitor = '64728728902';


-- Para contar as linhas da tabela categoria
SELECT count(*) FROM leitor;

-- Para deletar alguma categoria

DELETE FROM leitor
WHERE ra_leitor = '64728728902';