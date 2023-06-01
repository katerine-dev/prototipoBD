package prototipodb.database;

import java.sql.PreparedStatement;

/*
Atributos:
- Nome (String)
- RA (String)
- Email (String)

Métodos:
- Criar (CREATE) - ok
- Alterar (UPDATE) - ok
- Apagar (DELETE - excluir cadastro) - ok
 */
public class LeitorDb {

    private Database database;

    // Método construtor:
    public LeitorDb(Database database){
        this.database = database;
    }

    /* Método para criar um novo leitor usando uma conexão MySQL:
    Na qual, receberá nome, RA (como string) e email
    */
    public void criarLeitor(String nome, String RA, String email) throws Exception {
        String sql = "INSERT INTO leitor (nome_leitor, ra_leitor, email_leitor) VALUES (?, ?, ?)";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setString(1, nome);
        instrucao.setString(2, RA);
        instrucao.setString(3, email);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();

        System.out.println("Usuário criado! Seja bem vindo!");

    }

    /* Método para alterar algum leitor usando uma conexão MySQL:
    O ra servirá de referência para encontrar o leitor no banco de dados
    */
    public void alterarLeitor(String novoNome, String novoEmail, String RA) throws Exception {
        String sql = "UPDATE leitor SET nome_leitor = ?, email_leitor = ? WHERE ra_leitor = ?";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setString(1, novoNome);
        instrucao.setString(2, novoEmail);
        instrucao.setString(3, RA);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();


        System.out.println("Usuário alterado!");
    }

    /* Método para deletar algum leitor usando uma conexão MySQL:
    O ra servirá de referência para encontrar o leitor no banco de dados
    */
    public void deletarLeitor(String RA) throws Exception {
        String sql = "DELETE FROM leitor WHERE ra_leitor = (?)";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setString(1, RA);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();

        System.out.println("Leitor removido!");

    }
}
