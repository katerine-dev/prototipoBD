package prototipodb.view;

import prototipodb.database.Database;
import prototipodb.database.EmprestimoDb;
import prototipodb.database.LeitorDb;
import prototipodb.database.LivroDb;

import java.util.Scanner;
public class MetodosInterfaceL {
    public static void realizarAcoesLeitor(Database database) throws Exception {
        Scanner entrada = new Scanner(System.in);
        // Intância das classes usadas nas ações:
        // LIVROS E LIVROS CATEGORIAS: --------------------------------
        LivroDb livroDb = new LivroDb(database);
        LivroView livroView = new LivroView();
        // LEITOR: ----------------------------------------------------
        LeitorDb leitorDb = new LeitorDb(database);
        // EMPRESTIMO: ------------------------------------------------
        EmprestimoDb emprestimoDb = new EmprestimoDb(database);
        EmprestimoView emprestimoView = new EmprestimoView();

        // Interface
        System.out.println("Olá leitor!" + "\nVocê possui cadastro? Digite S (para sim)  ou N (para não)");
        String respostaCadastroLeitor = entrada.nextLine();

        if (respostaCadastroLeitor.equalsIgnoreCase("S")) {
            exibirMenuLeitor(database,
                    entrada,
                    livroDb,
                    livroView,
                    emprestimoDb,
                    emprestimoView);
        } else if (respostaCadastroLeitor.equalsIgnoreCase("N")) {
            cadastrarLeitor(
                    database,
                    entrada,
                    leitorDb);
            exibirMenuLeitor(database,
                    entrada,
                    livroDb,
                    livroView,
                    emprestimoDb,
                    emprestimoView);
        } else {
            System.out.println("Resposta inválida");
        }

    }

    /* Método para exibir o menu da sessão do Leitor.
    Aqui ficam todas as interações possíveis para o Leitor. 
     */
    public static void exibirMenuLeitor(Database database,
                                        Scanner entrada,
                                        LivroDb livroDb,
                                        LivroView livroView,
                                        EmprestimoDb emprestimoDb,
                                        EmprestimoView emprestimoView) throws Exception  {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("======= Menu Principal do Leitor ========");
            System.out.println("1 - Pesquisar Livros");
            System.out.println("2 - Realizar Empréstimo");
            System.out.println("3 - Devolver Livro");
            System.out.println("4 - Encerrar sessão");
            System.out.println("========================================");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    livroView.pesquisarLivrosInterface(
                            database,
                            entrada,
                            livroDb,
                            livroView);
                    break;
                case 2:
                    emprestimoView.realizarEmprestimoInterface(
                            database,
                            entrada,
                            emprestimoDb);
                    break;
                case 3:
                    emprestimoView.devolverLivroInterface(
                            database,
                            entrada,
                            emprestimoDb);
                    break;
                case 4:
                    System.out.println("Encerrando o programa.......");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    // Cadastro do leitor pela interface
    public static void cadastrarLeitor(Database database,
                                        Scanner entrada,
                                        LeitorDb leitorDb) throws Exception {

        System.out.println("Vamos fazer seu cadastro!");
        // Realizar cadastro do leitor
        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine();
        System.out.println("Digite seu RA: ");
        String RA = entrada.nextLine();
        System.out.println("Digite seu email: ");
        String email = entrada.nextLine();
        leitorDb.criarLeitor(nome, RA, email);
    }
}
