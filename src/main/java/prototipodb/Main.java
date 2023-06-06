package prototipodb;

import prototipodb.database.Database;
import prototipodb.view.MetodosInterfaceB;
import prototipodb.view.MetodosInterfaceL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String username = "root";
        String password = "rootroot";
        String databaseName = "BIBLIOTECA";
        String serverName = "localhost";
        Scanner entrada = new Scanner(System.in);
        // Conexão com o MySQL
        Database database = new Database(serverName, databaseName, password, username);

        // INTERFACE: ----
        System.out.println("Bem vindo(a) a essa biblioteca");
        System.out.println("Você é bibliotecário ou leitor?" + "\nDigite B para bibliotecário ou L para leitor:");
        String respostaUsuario = entrada.nextLine();

        if (respostaUsuario.equalsIgnoreCase("B")) {
            MetodosInterfaceB.realizarAcoesBibliotecario(database);
        } else if (respostaUsuario.equalsIgnoreCase("L")) {
            MetodosInterfaceL.realizarAcoesLeitor(database);
        } else {
            System.out.println("Resposta inválida");
        }
        entrada.close();
    }
}

