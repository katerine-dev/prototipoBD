package prototipodb.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
Atributos:
- Nome categoria (String)
- Código categoria (chave primaria - int)

Métodos:
- Inserir (INSERT) - ok
- Alterar (UPDATE) - ok
- Imprimir (READ)
 */
public class CategoriaDb {
    private Database database;

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


}
