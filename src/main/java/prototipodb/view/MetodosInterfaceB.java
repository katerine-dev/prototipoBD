package prototipodb.view;

import prototipodb.database.*;

import java.util.Scanner;

public class MetodosInterfaceB {

    public static void realizarAcoesBibliotecario(Database database) throws Exception {
        Scanner entrada = new Scanner(System.in);
        // Intância das classes usadas nas ações:
        // CATEGORIA: -------------------------------------------------
        CategoriaDb categoriaDb = new CategoriaDb(database);
        CategoriaView categoriaView = new CategoriaView();
        // LIVROS E LIVROS CATEGORIAS: --------------------------------
        LivroDb livroDb = new LivroDb(database);
        LivroView livroView = new LivroView();
        // LEITOR: ----------------------------------------------------
        LeitorDb leitorDb = new LeitorDb(database);
        LeitorView leitorView = new LeitorView();
        // BIBLIOTECARIA: ---------------------------------------------
        BibliotecariaDb bibliotecariaDb = new BibliotecariaDb(database);
        BibliotecariaView bibliotecariaView = new BibliotecariaView();
        // EMPRESTIMO: ------------------------------------------------
        EmprestimoDb emprestimoDb = new EmprestimoDb(database);
        EmprestimoView emprestimoView = new EmprestimoView();
        // USUÁRIO: ---------------------------------------------------
        UsuarioView usuarioView = new UsuarioView();

        // Interface
        System.out.println("Olá bibliotecário!" + "\nVocê possui cadastro? Digite S (para sim)  ou N (para não)");
        String respostaCadastroBibliotecaria = entrada.nextLine();

        if (respostaCadastroBibliotecaria.equalsIgnoreCase("S")) {
            exibirMenuBibliotecaria(
                    database,
                    entrada,
                    livroDb,
                    livroView,
                    categoriaView,
                    categoriaDb,
                    emprestimoDb,
                    emprestimoView,
                    bibliotecariaDb,
                    bibliotecariaView,
                    usuarioView,
                    leitorDb,
                    leitorView);
        } else if (respostaCadastroBibliotecaria.equalsIgnoreCase("N")) {
            cadastrarBibliotecaria(database, entrada, bibliotecariaDb);
            exibirMenuBibliotecaria(
                    database,
                    entrada,
                    livroDb,
                    livroView,
                    categoriaView,
                    categoriaDb,
                    emprestimoDb,
                    emprestimoView,
                    bibliotecariaDb,
                    bibliotecariaView,
                    usuarioView,
                    leitorDb,
                    leitorView);
        } else {
            System.out.println("Resposta inválida");
        }
    }
    /* Método para exibir o menu da sessão da bibliotecária.
    Aqui ficam todas as interações possíveis para a bibliotecária. 
     */
    private static void exibirMenuBibliotecaria(Database database,
                                                Scanner entrada,
                                                LivroDb livroDb,
                                                LivroView livroView,
                                                CategoriaView categoriaView,
                                                CategoriaDb categoriaDb,
                                                EmprestimoDb emprestimoDb,
                                                EmprestimoView emprestimoView,
                                                BibliotecariaDb bibliotecariaDb,
                                                BibliotecariaView bibliotecariaView,
                                                UsuarioView usuarioView,
                                                LeitorDb leitorDb,
                                                LeitorView leitorView) throws Exception {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("======= Menu Principal da Bibliotecária ========");
            System.out.println("Selecione o que deseja fazer:");
            System.out.println("1 - Livros");
            System.out.println("2 - Categorias");
            System.out.println("3 - Usuários");
            System.out.println("4 - Empréstimos");
            System.out.println("5 - Encerrar sessão");
            System.out.println("================================================");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    livroView.realizarAcoesLivros(
                            database,
                            entrada,
                            livroDb,
                            livroView,
                            categoriaDb,
                            categoriaView);
                    break;
                case 2:
                    categoriaView.realizarAcoesCategorias(
                            database,
                            entrada,
                            categoriaDb,
                            categoriaView);
                    break;
                case 3:
                     usuarioView.realizarAcoesUsuarios(
                             database,
                             entrada,
                             bibliotecariaView,
                             leitorView,
                             bibliotecariaDb,
                             leitorDb);
                    break;
                case 4:
                    emprestimoView.realizarAcoesEmprestimos(
                            database,
                            entrada,
                            emprestimoDb,
                            emprestimoView);
                    break;
                case 5:
                    System.out.println("Encerrando o programa.......");
                    opcao = 0;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    // Método para cadastro da bibliotecária pela interface.
    public static void cadastrarBibliotecaria(Database database,
                                              Scanner entrada,
                                              BibliotecariaDb bibliotecariaDb) throws Exception {
        System.out.println("Vamos fazer seu cadastro!");
        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine();
        System.out.println("Digite seu CPF: ");
        String CPF = entrada.nextLine();
        System.out.println("Digite seu email: ");
        String email = entrada.nextLine();
        bibliotecariaDb.criarBibliotecaria(nome, CPF, email);
    }
}
