package prototipodb;

import prototipodb.database.*;
import prototipodb.model.*;
import prototipodb.view.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String username = "root";
        String password = "rootroot";
        String databaseName = "BIBLIOTECA";
        String serverName = "localhost";

        Database database = new Database(serverName, databaseName, password, username);

        Scanner entrada = new Scanner(System.in);


        System.out.println("Bem vindo(a) a essa biblioteca");
        System.out.println("Você é bibliotecário ou leitor?" + "\nDigite B para bibliotecário ou L para leitor:");
        //variável resposta vai receber uma entrada do usuário
        String respostaUsuario = entrada.nextLine();

        //equals = comparador de string que ignora o 'sentive case' se é maiúsculo ou minúsculo
        if (respostaUsuario.equalsIgnoreCase("B")) {
            System.out.println("Olá bibliotecário!" + "\nVocê possui cadastro? Digite S (para sim)  ou N (para não)");
            String respostaCadastroBibliotecaria = entrada.nextLine();
            if(respostaCadastroBibliotecaria.equalsIgnoreCase("S")) {

                //chama o método que entra no sistema do bibliotecário
                System.out.println("Selecione o que deseja fazer:");

                //opp = primeira opção
                int opp = 1;

                while(opp !=0) {
                    System.out.println("======= Menu Principal da Biliotecária ========");
                    System.out.println("1 - Livros");
                    System.out.println("2 - Categorias");
                    System.out.println("3 - Usuarios");
                    System.out.println("4 - Emprestimos");
                    System.out.println("5 - Encerra sessão");

                    int op1 = entrada.nextInt();

                    switch (op1){
                        case 1:
                            int op11 = 1;

                            while (op11 != 0);{
                            System.out.println("Você selecionou Livros");
                            System.out.println("=== Menu Livros ===");
                            System.out.println("1 - Visualizar Livros");
                            System.out.println("2 - Criar Livro");
                            System.out.println("3 - Alterar Livros");
                            System.out.println("4 - Deletar Livros");
                            System.out.println("0 - Voltar ao menu anterior");

                            op11 = entrada.nextInt();

                            LivroDb livroDb = new LivroDb(database);
                            LivroView livroView = new LivroView();

                            switch (op11){

                                //visualiza a lista de livros
                                case 1:

                                    Livro[] livros = livroDb.lerLivros();
                                    livroView.mostrarLivros(livros);

                                    break;

                                //cria livros
                                case 2:

                                    System.out.println("Digite o nome do livro: ");
                                    String titulo = entrada.nextLine();
                                    System.out.println("Digite o nome do autor: ");
                                    String autor = entrada.nextLine();
                                    System.out.println("Digite o código da categoria: ");
                                    int codigosCategoria = entrada.nextInt();
                                    livroDb.criarLivro(titulo,autor,new int[] {});
                                    //livroDb.criarLivro("Orgulho e nada", "Jane Austen", new int[] {1,2});

                                    break;

                                //altera livros
                                case 3:
                                    System.out.println("Digite o código do livro que deseja alterar: ");
                                    int codigoLivro = entrada.nextInt();
                                    System.out.println("Digite o novo nome do livro: ");
                                    String novoTitulo = entrada.nextLine();
                                    System.out.println("Digite o novo nome do autor: ");
                                    String novoAutor = entrada.nextLine();
                                    livroDb.alterarLivro(codigoLivro,novoTitulo,novoAutor);
                                    break;

                                //deleta livros da biblioteca
                                case 4:
                                    System.out.println("Digite o código do livro que deseja excluir: ");
                                    codigoLivro = entrada.nextInt();
                                    livroDb.deletarLivro(codigoLivro);
                                    break;

                                case 0:
                                    // voltar ao menu anterior (while)
                                    break;

                                default:
                                    System.out.println("opção invalida");
                                    break;
                            }

                        }

                        break;

                        case 2:

                            int op2 = 1;

                            while (op2 != 0) {
                                System.out.println("Você selecionou as opções de Categorias");
                                System.out.println("=== Menu Categorias ===");
                                System.out.println("1 - Visualizar");
                                System.out.println("2 - Criar");
                                System.out.println("3 - Alterar");
                                System.out.println("0 - Voltar ao menu anterior");



                                op2 = entrada.nextInt();
                                CategoriaDb categoriaDb = new CategoriaDb(database);

                                switch (op2){

                                    //visualiza a lista de categorias
                                    case 1:
                                        CategoriaView categoriaView = new CategoriaView();
                                        Categoria[] categorias = categoriaDb.lerCategorias();
                                        categoriaView.mostrarCategorias(categorias);
                                        break;

                                    //cria livros
                                    case 2:
                                        System.out.println("Digite a nova categoria: ");
                                        String novaCategoria = entrada.nextLine();
                                        categoriaDb.criarCategoria(novaCategoria);

                                        break;

                                    //altera as categorias da biblioteca
                                    case 3:
                                        System.out.println("Nome da nova categoria: ");
                                        novaCategoria = entrada.nextLine();
                                        System.out.println("Código para alterar a categoria: ");
                                        int codigo = entrada.nextInt();
                                        categoriaDb.alterarCategoria(novaCategoria, codigo);

                                        break;

                                    case 0:
                                        // voltar ao menu anterior (while)
                                        break;

                                    default:
                                        System.out.println("opção invalida");
                                        break;
                                }
                            }
                            break;

                        case 3:

                            int op3 = 1;

                            while (op3 !=0){
                                System.out.println("Você selecionou usuário");
                                System.out.println("=== Menu usuário ===");
                                System.out.println("1 - Bibliotecario");
                                System.out.println("2 - Leitor");
                                System.out.println("0 - Voltar ao menu anterior");

                                op3 = entrada.nextInt();
                                switch (op3){

                                    case 1: //ele é o while op33

                                        int op33 = 1;


                                        while (op33 != 0){
                                            System.out.println("Você selecionou as opções de Bibliotecaria");
                                            System.out.println("=== Menu Bibliotecario ===");
                                            System.out.println("1 - Criar");
                                            System.out.println("2 - Alterar");
                                            System.out.println("3 - Deletar");
                                            System.out.println("0 - Voltar ao menu anterior");

                                            op33 = entrada.nextInt();
                                            BibliotecariaDb bibliotecariaDb = new BibliotecariaDb(database);

                                            switch (op33){

                                                //cria a bibliotecária
                                                case 1:
                                                    System.out.println("Digite o nome da nova bibliotecária: : ");
                                                    String nome = entrada.nextLine();
                                                    System.out.println("Digite seu CPF: ");
                                                    String CPF = entrada.nextLine();
                                                    System.out.println("Digite seu email: ");
                                                    String email = entrada.nextLine();
                                                    bibliotecariaDb.criarBibliotecaria(nome, CPF, email);

                                                    break;

                                                //altera a bibliotecária
                                                case 2:
                                                    System.out.println("Digite o novo nome da bibliotecária: : ");
                                                    String novoNome = entrada.nextLine();
                                                    System.out.println("Digite o novo email: ");
                                                    String novoEmail = entrada.nextLine();
                                                    System.out.println("Digite o novo CPF: ");
                                                    CPF = entrada.nextLine();
                                                    bibliotecariaDb.alterarBibliotecaria(novoNome,novoEmail, CPF);


                                                    break;


                                                //deleta a bibliotecária
                                                case 3:
                                                    System.out.println("Digite o CPF que deseja deletar: ");
                                                    CPF = entrada.nextLine();
                                                    bibliotecariaDb.deletarBibliotecaria(CPF);
                                                    break;

                                                case 0:
                                                    // voltar ao menu anterior (while)
                                                    break;

                                                default:
                                                    System.out.println("opção invalida");
                                                    break;
                                            }
                                        }
                                        break;
                                    case 2:

                                        int op333 = 1;
                                        while (op333 !=0) {
                                            System.out.println("Você selecionou as opções de Leitor");
                                            System.out.println("=== Menu Leitor ===");
                                            System.out.println("1 - Alterar");
                                            System.out.println("2 - Deletar");
                                            System.out.println("0 - Voltar ao menu anterior");

                                            LeitorDb leitorDb = new LeitorDb(database);

                                            op333 = entrada.nextInt();

                                            switch (op333){

                                                //chama o método de alterar o leitor

                                                case 1:

                                                    System.out.println("Digite o nome do novo leitor: ");
                                                    String novoNome = entrada.nextLine();
                                                    System.out.println("Digite o novo email do leitor: ");
                                                    String novoEmail = entrada.nextLine();
                                                    System.out.println("Digite o novo RA do leitor: ");
                                                    String RA = entrada.nextLine();
                                                    leitorDb.alterarLeitor(novoNome,RA, novoEmail);

                                                    break;

                                                //deleta um leitor
                                                case 2:

                                                    System.out.println("Digite o RA do leitor que deseja deletar: ");
                                                    RA = entrada.nextLine();
                                                    leitorDb.deletarLeitor(RA);
                                                    break;

                                                case 0:
                                                    // voltar ao menu anterior (while)
                                                    break;

                                                default:
                                                    System.out.println("opção invalida");
                                                    break;
                                            }
                                        }
                                }
                            }
                            break;

                        case 4:
                            int op4 = 1;

                            while (op4 != 0){
                                System.out.println("Você selecionou as opções de Emprestimos.");
                                System.out.println("=== Menu Emprestimos ===");
                                System.out.println("1 - Visualizar");
                                System.out.println("0 - Voltar ao menu anterior");

                                op4 = entrada.nextInt();
                                switch (op4){

                                    //visualiza todos os emprestimos da biblioteca
                                    case 1:
                                        EmprestimoDb emprestimoDb = new EmprestimoDb(database);
                                        EmprestimoView emprestimoView = new EmprestimoView();
                                        Emprestimo[] emprestimos = emprestimoDb.lerEmprestimo();
                                        emprestimoView.mostrarEmprestimos(emprestimos);
                                        break;

                                    case 0:
                                        // voltar ao menu anterior (while)
                                        break;

                                    default:
                                        System.out.println("opção invalida");
                                        break;}
                            }
                            break;

                        case 5:
                            System.out.println("Encerrando o progama.......");
                            opp = 0;
                            break;

                        default:
                            System.out.println("opção invalida");
                            break;
                    }
                }

                //resposta alternativa NAO
            } else if (respostaCadastroBibliotecaria.equalsIgnoreCase("N")) { // Se coloca ~ não funciona
                System.out.println("vamos fazer  seu cadastro!");

                //chama o método de cadastro do bibliotecário
                BibliotecariaDb bibliotecariaDb = new BibliotecariaDb(database);
                System.out.println("Digite seu nome: ");
                String nome = entrada.nextLine();
                System.out.println("Digite seu CPF: ");
                String CPF = entrada.nextLine();
                System.out.println("Digite seu email: ");
                String email = entrada.nextLine();
                bibliotecariaDb.criarBibliotecaria(nome, CPF, email);
            }





        }


        //parte do leitor
        //L = leitor
        else if (respostaUsuario.equalsIgnoreCase("L")) {
            System.out.println("Olá leitor!" + "\nVocê possui cadastro? Digite SIM ou NÃO");
            String respostaCadastroLeitor = entrada.nextLine();
            if (respostaCadastroLeitor.equalsIgnoreCase("SIM")) {
                //chama o método que entra no sistema do leitor
                //SWITCH DO LEITOR

            } else if (respostaCadastroLeitor.equalsIgnoreCase("NAO")){ // Se coloca ~ não funciona
                System.out.println("vamos fazer  seu cadastro!");

                //chama o método de cadastro do bibliotecário
                LeitorDb leitorDb = new LeitorDb(database);
                System.out.println("Digite seu nome: ");
                String nome = entrada.nextLine();
                System.out.println("Digite seu RA: ");
                String RA = entrada.nextLine();
                System.out.println("Digite seu email: ");
                String email = entrada.nextLine();
                leitorDb.criarLeitor(nome,RA, email);
            }

        } else {
            System.out.println("ERROR");
        }




        // IGNORA A PARTE DE BAIXO
        //TESTES DE INTERAÇÃO COM BANCO DE DADOS:
        // CATEGORIA: ____________________________________
        CategoriaDb categoriaDb = new CategoriaDb(database);
        CategoriaView categoriaView = new CategoriaView();
        // - Criar categoria:
        // categoriaDb.criarCategoria("Terror");
        // - Alterar categoria:
        // categoriaDb.alterarCategoria("Infantil", 1);
        // - Ler categorias:
        // Categoria[] categorias = categoriaDb.lerCategorias();
        // - Imprime categorias:
        // categoriaView.mostrarCategorias(categorias);

        // LIVROS E LIVROS CATEGORIAS: ______________________
        LivroDb livroDb = new LivroDb(database);
        LivroView livroView = new LivroView();

        // - Criar livro:
        // livroDb.criarLivro("Orgulho e Preconceito", "Jane Austen", new int[] {1,2});
        // livroDb.criarLivro("1984", "George Orwell", new int[] {1});
        // livroDb.criarLivro("Crime e Castigo", "Fiódor Dostoiévski", new int[] {1,4});
        // livroDb.criarLivro("Hamlet", "William Shakespeare", new int[] {5});
        // livroDb.criarLivro("Cem Anos de Solidão", "Gabriel Márquez", new int[] {1,6});
        // livroDb.criarLivro("Anna Kariênina", "Liev Tolstói", new int[] {1,2});
        

        // Deletar livros:
        // livroDb.deletarLivro(5);
        // - Alterar categoria:
        // livroDb.alterarLivro(5, "coisinha", "coisinha");
        // - Ler Livros:
        // Livro[] livros = livroDb.lerLivros();
        // - Imprime categorias:
        // livroView.mostrarLivros(livros);
        // - Filtro por nome do livro:
        // Livro[] livros = livroDb.filtroLivrosTitulo("Orgulho e Preconceito");
        // livroView.mostrarFiltroPorTítulo(livros);
        // - Filtro por nome do livro:
        // Livro[] livros = livroDb.filtroLivrosCategoria("Romance");
        // livroView.mostrarFiltroPorCategoria(livros);

        // LEITOR: ---------------------------------------------
        LeitorDb leitorDb = new LeitorDb(database);
        // criar leitor:
        // leitorDb.criarLeitor("Katerine Witkoski", "12344559", "katerinewitkoski@gmail.com");
        // - Alterar leitor:
        // leitorDb.alterarLeitor("Katerine Witkoski", "katerinewitkoski@email.com", "123456789");
        // Deletar leitor:
        // leitorDb.deletarLeitor("123456789");

        // BIBLIOTECARIA: ---------------------------------------------
        BibliotecariaDb bibliotecariaDb = new BibliotecariaDb(database);
        // criar Bibliotecaria:
        // bibliotecariaDb.criarBibliotecaria("Katerine Witkoski", "11111111111", "katerinewitkoski@email.com");
        // - Alterar Bibliotecaria:
        // bibliotecariaDb.alterarBibliotecaria("Katerine Witkoski novo", "katerinewitkoskinovo@email.com", "11111111111");
        // Deletar leitor:
        // bibliotecariaDb.deletarBibliotecaria("11111111111");

        // EMPRESTIMO: ---------------------------------------------
        EmprestimoDb emprestimoDb = new EmprestimoDb(database);
        EmprestimoView emprestimoView = new EmprestimoView();
        // Alugar livro:
        // emprestimoDb.reservarLivro("09876543211", 3);
        // Devolver livro:
        // emprestimoDb.devolverLivro(1, "12345678910");
        // - Ler Emprestimos:
        // Emprestimo[] emprestimos = emprestimoDb.lerEmprestimo();
        // - Imprime categorias:
        // emprestimoView.mostrarEmprestimos(emprestimos);

    }
}

