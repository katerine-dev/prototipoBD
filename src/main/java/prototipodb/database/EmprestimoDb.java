package prototipodb.database;
import prototipodb.model.Emprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

/*
Atributos:
- Codigo Livros (Chave estrangeira da tabela livros)
- Status (String - somente 2 possíveis - Reservado/Disponível)
- RA_usuario (String)

Métodos:
- Ler e imprimir (READ)
- Criar método para reserva e devolução de livros (INSERT e UPDATE)
 */

public class EmprestimoDb {
     private Database database;
     
     // Método construtor:
    public EmprestimoDb(Database database){
        this.database = database;
    }

    // Método para verificar se tem disponibilidade do livro
    private boolean verificarDisponibilidadeLivro(int codLivro) throws SQLException {
        String sql = "SELECT status_livro FROM leitorEmprestimo WHERE cod_livro = ?";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);
        instrucao.setInt(1, codLivro);
        ResultSet resultSet = instrucao.executeQuery();

        if (resultSet.next()) {
            String statusLivro = resultSet.getString("status_livro");
            return !statusLivro.equalsIgnoreCase("alugado");
        }
        return true;
    }

    /* Método para reservar livro usando uma conexão MySQL:
    Ele receberá um ra e um código do livro, primeiro precisamos verificar se o livro está disponível para
    reserva caso não solte uma mensagem "O livro não está disponível para reserva."
    */
    public void reservarLivro(String raLeitor, int codLivro) throws Exception {

        boolean livroDisponivel = verificarDisponibilidadeLivro(codLivro);

        if (livroDisponivel) {
            // Inserir reserva na tabela leitorEmprestimo
            String sql = "INSERT INTO leitorEmprestimo (cod_livro, status_livro, ra_leitor) VALUES (?, ?, ?)";
            PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);
            instrucao.setInt(1, codLivro);
            instrucao.setString(2, "alugado");
            instrucao.setString(3, raLeitor);
            instrucao.executeUpdate();

            System.out.println("Livro reservado com sucesso!");
        } else {
            System.out.println("O livro não está disponível para reserva.");
        }

    }

    // Método para verificar se o livro foi emprestado por esse leitor
    private boolean verificarLivroEmprestado(int codLivro, String raLeitor) throws SQLException {
        String sql = "SELECT status_livro FROM leitorEmprestimo WHERE cod_livro = ? AND ra_leitor = ?";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);
        instrucao.setInt(1, codLivro);
        instrucao.setString(2, raLeitor);
        ResultSet resultSet = instrucao.executeQuery();

        return resultSet.next();
    }

    /* Método para devolver livro usando uma conexão MySQL:
    Ele receberá um ra e um código do livro, primeiro precisamos verificar se o livro foi realmente reservado por esse
    leitor caso não solte uma mensagem "O livro não está emprestado."
    */
    public void devolverLivro(int codLivro, String raLeitor) throws Exception {

        boolean livroEmprestado = verificarLivroEmprestado(codLivro, raLeitor);

        if (!livroEmprestado) {
            System.out.println("O livro não está emprestado.");
            return;
        }
            // Alterar a reserva na tabela leitorEmprestimo
            String sql = "UPDATE leitorEmprestimo SET status_livro = ? WHERE cod_livro = ? AND ra_leitor = ?";
            PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);
            // Definir os valores dos parâmetros
            instrucao.setString(1, "devolvido");
            instrucao.setInt(2, codLivro);
            instrucao.setString(3, raLeitor);
            instrucao.executeUpdate();

            System.out.println("Livro devolvido com sucesso!");

    }

    /* Método para ler emprestimo usando uma conexão MySQL: (método que auxilia o mostrarEmprestimos())
    Inicialmente precisamos definir um vetor para atribuir um LIMIT no SELECT/JOIN.
    E com os resultados da query atribuir os valores no novo vetor.
    */
    public Emprestimo[] lerEmprestimo() throws Exception {
        // Preciso definir o tamanho do vetor
        String sqlCountEmprestimos = "SELECT count(*) FROM leitorEmprestimo";
        PreparedStatement instrucaoCountEmprestimos = this.database.getConnection().prepareStatement(sqlCountEmprestimos);
        ResultSet resultadosCountEmprestimos = instrucaoCountEmprestimos.executeQuery(sqlCountEmprestimos);
        resultadosCountEmprestimos.next();
        int maximoNumeroDeResultados = resultadosCountEmprestimos.getInt(1);

        String sql = "SELECT * FROM leitorEmprestimo LIMIT " +  maximoNumeroDeResultados;
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);


        // Executar a instrução SQL da variável `instrucao`
        ResultSet resultados = instrucao.executeQuery();
        Emprestimo[] emprestimos = new Emprestimo[maximoNumeroDeResultados];

        int i = 0;
        while (resultados.next()) { 
            int codigoLivro = resultados.getInt(1);
            String statusLivro = resultados.getString(2);
            String raLeitor = resultados.getString(3);
            
            Emprestimo emprestimo = new Emprestimo(codigoLivro, statusLivro, raLeitor);
            emprestimos[i] = emprestimo;
            i++;
        }

        return emprestimos;
    }
}
