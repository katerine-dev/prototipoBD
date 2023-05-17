package prototipodb;

import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
    private Connection connection; // atributo do tipo Connection

    //Método Construtor da Classe
    public Database(String serverName, String databaseName, String password, String username) throws Exception {
        /* EXCEPTION é a classe do java que simboliza erros
        - esse throws Eception está dizendo que esse método pode levantar uma exceção (um erro)
        - throw é jogar
        - "try/catch - tentar/pegar"
        - o throw define na assinatura do método que ele estourar? (dar erro, jogar uma exceção)
        */

        // Configurando a nossa conexão com um banco de dados

        // String serverName = "localhost"; //caminho do servidor do BD
        // String databaseName ="BIBLIOTECA"; //nome do seu banco de dados
        // String username = "root"; //nome de um usuário de seu BD
        // String password = "rootroot"; //sua senha de acesso
        String url =  "jdbc:mysql://" + serverName + "/" + databaseName;
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return this.connection;
    }

}