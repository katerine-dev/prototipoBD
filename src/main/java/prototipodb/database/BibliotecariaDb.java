package prototipodb.database;

import java.sql.PreparedStatement;

/*
Atributos:
- Nome (String)
- CPF (String)
- Email (String)

Métodos:
- Criar (CREATE) - ok
- Alterar (UPDATE) - ok
- Apagar (DELETE - excluir cadastro) - ok
 */
public class BibliotecariaDb {
    private Database database;

    // Método construtor:
    public BibliotecariaDb(Database database){
        this.database = database;
    }

    public void criarBibliotecaria(String nome, String CPF, String email) throws Exception {
        String sql = "INSERT INTO bibliotecaria (nome_bibliotecaria, cpf_bibliotecaria, email_bibliotecaria) VALUES (?, ?, ?)";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setString(1, nome);
        instrucao.setString(2, CPF);
        instrucao.setString(3, email);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();

        System.out.println("Usuário criado! Seja Bem Vindo a nossa empresa!");

    }

    public void alterarBibliotecaria(String novoNome, String novoEmail, String CPF) throws Exception {
        String sql = "UPDATE bibliotecaria SET nome_bibliotecaria = ?, email_bibliotecaria = ? WHERE cpf_bibliotecaria = ?";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setString(1, novoNome);
        instrucao.setString(2, novoEmail);
        instrucao.setString(3, CPF);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();


        System.out.println("Usuário de bibliotecária alterado!");
    }

    public void deletarBibliotecaria(String CPF) throws Exception {
        String sql = "DELETE FROM bibliotecaria WHERE cpf_bibliotecaria = (?)";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setString(1, CPF);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();

        System.out.println("Usuario de Bibliotecaria removido!");

    }

}
