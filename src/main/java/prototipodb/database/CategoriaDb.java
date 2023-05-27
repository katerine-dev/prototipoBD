package prototipodb.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

/*
Atributos:
- Nome categoria (String)
- Código categoria (chave primaria - int)

Métodos:
- Inserir (INSERT) - ok
- Alterar (UPDATE) - ok
- Imprimir (SELECT) - ok
 */
public class CategoriaDb {
    private Database database;

    // Método construtor:
    public CategoriaDb(Database database){
        this.database = database;
    }

    public void criarCategoria(String novaCategoria) throws Exception {
        String sql = "INSERT INTO categoria (nome_categoria) VALUES (?)";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setString(1, novaCategoria);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();

        System.out.println("Categoria criada!");

    }
    public void alterarCategoria(String novaCategoria, int codigo) throws Exception {
        String sql = "UPDATE categoria SET nome_categoria = (?) WHERE cod_categoria = (?)";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setString(1, novaCategoria);
        instrucao.setInt(2, codigo);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();


        System.out.println("Categoria alterada!");
    }

    public void mostrarCategorias(String nomeTabela) throws Exception {
        String sql = "SELECT * FROM " + nomeTabela;
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Executar a instrução SQL da variável `instrucao`
        ResultSet resultados = instrucao.executeQuery(sql);

        String[] cabecalho = {"Código categoria", "Nome"};

        // Imprimindo cabeçalho da tabela
        for (int i = 0; i < cabecalho.length; i++) {
            System.out.print(cabecalho[i] + "\t"); // caractere de tabulação
        }
        System.out.println();

        // Imprimindo linhas da tabela
        while (resultados.next()) {
            for (int i = 0; i < cabecalho.length; i++) {
                System.out.print(resultados.getString(i + 1) + "\t"); // Esse + 1 é para ajustar o indice, pois o
                // jdbc o indice começa em 1 e o vetor começa em 0
            }
            System.out.println();
        }

    }

}
