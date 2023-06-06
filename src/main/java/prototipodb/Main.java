package prototipodb;

import prototipodb.database.*;
import prototipodb.view.*;

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
            MetodosInterfaceB.realizarAcoesBibliotecario();
        } else if (respostaUsuario.equalsIgnoreCase("L")) {
            // realizarAcoesLeitor();
        } else {
            System.out.println("Resposta inválida");
        }
    }
}

