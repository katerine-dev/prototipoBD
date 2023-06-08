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
            // Separamos em ações para Bibliotecária e Leitores
            MetodosInterfaceB.realizarAcoesBibliotecario(database);
        } else if (respostaUsuario.equalsIgnoreCase("L")) {
            MetodosInterfaceL.realizarAcoesLeitor(database);
        } else {
            System.out.println("Resposta inválida");
        }
        entrada.close();

       /* Criação dos dados da tabela livro
       Precisa dar import na classe LivroDb.
        LivroDb livroDb = new LivroDb(database);
        livroDb.criarLivro("Orgulho e Preconceito", "Jane Austen", new int[] {1,2});
        livroDb.criarLivro("1984", "George Orwell", new int[] {1});
        livroDb.criarLivro("Crime e Castigo", "Fiódor Dostoiévski", new int[] {1,4});
        livroDb.criarLivro("Hamlet", "William Shakespeare", new int[] {5});
        livroDb.criarLivro("Cem Anos de Solidão", "Gabriel Márquez", new int[] {1,6});
        livroDb.criarLivro("Anna Kariênina", "Liev Tolstói", new int[] {1,2});
        livroDb.criarLivro("Odisseia", "Homero", new int[] {7,14});
        livroDb.criarLivro("Fausto", "Johann Wolfgang Von Goethe", new int[] {5});
        livroDb.criarLivro("O Homem sem Qualidades ", "Robert Musil", new int[] {1,8});
        livroDb.criarLivro("O Homem sem Qualidades ", "Robert Musil", new int[] {1,8});
        livroDb.criarLivro("O estrangeiro", "Albert Camus", new int[] {1,9});
        livroDb.criarLivro("As Mil e uma Noites", "Antoine Gallang", new int[] {10,11});
        livroDb.criarLivro("As Mil e uma Noites", "Antoine Gallang", new int[] {10,11});
        livroDb.criarLivro("Anna Kariênina", "Liev Tolstói", new int[] {10,11});
        livroDb.criarLivro("Os irmãos Karamazov", "Fiódor Dostoiévski", new int[] {1,2,12});*/

    }
}

