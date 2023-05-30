package prototipodb.database;

import prototipodb.model.Categoria;

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

    public Categoria[] lerCategorias() throws Exception {
        // Preciso definir o tamanho do vetor
        String sqlCountCategorias = "SELECT count(*) FROM categoria";
        PreparedStatement instrucaoCountCategorias = this.database.getConnection().prepareStatement(sqlCountCategorias);
        ResultSet resultadosCountCategorias = instrucaoCountCategorias.executeQuery(sqlCountCategorias);
        resultadosCountCategorias.next();
        int maximoNumeroDeResultados = resultadosCountCategorias.getInt(1);

        String sql = "SELECT * FROM categoria LIMIT " +  maximoNumeroDeResultados;
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);


        // Executar a instrução SQL da variável `instrucao`
        ResultSet resultados = instrucao.executeQuery(sql);
        Categoria[] categorias = new Categoria[maximoNumeroDeResultados];

        int i = 0;
        while (resultados.next()) { // iterar (passar por todos os elementos) o resultado vindo do banco
            // getInt/getString pega a posição da informação na linha retornada por exemplo:
            // [1, "acao"]
            // [2, "terror"]
            // [3, "comedia"]
            int codigoCategoria = resultados.getInt(1);
            String nomeCategoria = resultados.getString(2);
            Categoria categoria = new Categoria(codigoCategoria, nomeCategoria);
            categorias[i] = categoria;
            i = i + 1;
        }

        return categorias;
    }

}
