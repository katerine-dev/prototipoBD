package prototipodb;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {
        String username = "root";
        String password = "rootroot";
        String databaseName = "BIBLIOTECA";
        String serverName = "localhost";

        Database database = new Database(serverName, databaseName, password, username);

        Connection c = database.getConnection();
        System.out.println(c);

    }
}

