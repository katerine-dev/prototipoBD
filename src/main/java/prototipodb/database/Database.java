package prototipodb.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
    private Connection connection; // atributo do tipo Connection

    //Método Construtor da Classe
    public Database(String serverName, String databaseName, String password, String username) throws Exception {
        /* EXCEPTION é a classe do java que simboliza erros
        - esse throws Exception está dizendo que esse método pode levantar uma exceção (um erro)
        - throw é jogar
        - "try/catch - tentar/pegar"
        - o throw define na assinatura do método que ele estourar? (dar erro, jogar uma exceção)

        serverName = caminho do servidor do BD
        databaseName = nome do seu banco de dados
        username = nome de um usuário de seu BD
        password = sua senha de acesso
        */
        String url =  "jdbc:mysql://" + serverName + "/" + databaseName;
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return this.connection;
    }

}