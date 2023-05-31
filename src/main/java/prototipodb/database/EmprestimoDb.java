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
    
    public void criarStatus(String novoStatus) throws Exception {
        String sql = "INSERT INTO emprestimo (status_livro) VALUES (?)";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);
        
        // Definir os valores dos parâmetros
        instrucao.setString(1, novoStatus);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();

        System.out.println("Status criado!");

    }

    public void alterarStatus(String novoStatus, int codigo, String RA) throws Exception {
        String sql = "UPDATE emprestimo SET status_livro = (?) WHERE cod_livro = (?) && RA_ = (?)";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setString(1, novoStatus);
        instrucao.setInt(2, codigo);
        instrucao.setString(3, RA);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();


        System.out.println("Status alterado!");
    }

    public Emprestimo[] lerEmprestimo() throws Exception {
        // Preciso definir o tamanho do vetor
        String sqlCountEmprestimos = "SELECT count(*) FROM emprestimo";
        PreparedStatement instrucaoCountEmprestimos = this.database.getConnection().prepareStatement(sqlCountEmprestimos);
        ResultSet resultadosCountEmprestimos = instrucaoCountEmprestimos.executeQuery(sqlCountEmprestimos);
        resultadosCountEmprestimos.next();
        int maximoNumeroDeResultados = resultadosCountEmprestimos.getInt(1);

        String sql = "SELECT * FROM emprestimo LIMIT " +  maximoNumeroDeResultados;
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
