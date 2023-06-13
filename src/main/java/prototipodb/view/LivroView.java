package prototipodb.view;

import prototipodb.database.CategoriaDb;
import prototipodb.database.Database;
import prototipodb.database.LivroDb;
import prototipodb.model.Categoria;
import prototipodb.model.Livro;

import java.util.Scanner;


public class LivroView {

    /* Método para visualizar a tabela livros: (método dependente do lerLivros())
    Inicialmente passamos um vetor com todos os nomes de colunas já existentes na tabela livros imprimindo
    o cabeçalho.
    Após utilizando o vetor criado em lerLivros(), imprimimos linha por linha, tabelando as informações.
    */
    public void mostrarLivros(Livro[] livros) {

        String[] cabecalho = {"Código Livro", "Título", " Autor", "Código Categoria", "Nome Categoria"};

        // Imprimindo cabeçalho da tabela
        for (int i = 0; i < cabecalho.length; i++) {
            System.out.print(cabecalho[i] + "\t"); // caractere de tabulação
        }
        System.out.println();

        // Imprimindo as linhas da tabela
        for (int j = 0; j < livros.length; j++){
            System.out.print(livros[j].getCodigo() + " | \t");
            System.out.print(livros[j].getTitulo() + " | \t");
            System.out.print(livros[j].getAutor() + " | \t");
            System.out.print(livros[j].getCategoria().getCodigo() + " | \t");
            System.out.print(livros[j].getCategoria().getNome() + " | \t");
            System.out.println();
        }
    }

    /* Método para visualizar o que foi filtrado (por título) da tabela livros: (método dependente do filtroLivrosTitulo())
    Inicialmente passamos um vetor com todos os nomes de colunas já existentes na tabela livros imprimindo
    o cabeçalho.
    Após utilizando o vetor criado em filtroLivrosTitulo(), imprimimos linha por linha, tabelando as informações.
    */
    public void mostrarFiltroPorTítulo(Livro[] livros) {

        String[] cabecalho = {"Código Livro", "Título", " Autor"};

        // Imprimindo cabeçalho da tabela
        for (int i = 0; i < cabecalho.length; i++) {
            System.out.print(cabecalho[i] + "\t"); // caractere de tabulação
        }
        System.out.println();

        // Imprimindo as linhas da tabela
        for (int j = 0; j < livros.length; j++){
            // preciso garantir que o objeto livros[j] seja devidamente inicializado
            // antes de acessar os métodos
            Livro livro = livros[j];
            if (livro != null) {
                System.out.print(livros[j].getCodigo() + " | \t");
                System.out.print(livros[j].getTitulo() + " | \t");
                System.out.print(livros[j].getAutor() + " | \t");
                System.out.println();
            }
        }
    }

    /* Método para visualizar o que foi filtrado (por categoria) da tabela livrosCategoria: (método dependente do filtroLivrosCategoria())
    Inicialmente passamos um vetor com todos os nomes de colunas já existentes na tabela livros imprimindo
    o cabeçalho.
    Após utilizando o vetor criado em filtroLivrosCategoria(), imprimimos linha por linha, tabelando as informações.
    */
    public void mostrarFiltroPorCategoria(Livro[] livros) {

        String[] cabecalho =  {"Código Livro", "Título", " Autor", "Código Categoria", "Nome Categoria"};

        // Imprimindo cabeçalho da tabela
        for (int i = 0; i < cabecalho.length; i++) {
            System.out.print(cabecalho[i] + "\t"); // caractere de tabulação
        }
        System.out.println();

        // Imprimindo as linhas da tabela
        for (int j = 0; j < livros.length; j++){
            // preciso garantir que o objeto livros[j] seja devidamente inicializado
            // antes de acessar os métodos
            Livro livro = livros[j];
            if (livro != null) {
                System.out.print(livros[j].getCodigo() + " | \t");
                System.out.print(livros[j].getTitulo() + " | \t");
                System.out.print(livros[j].getAutor() + " | \t");
                System.out.print(livros[j].getCategoria().getCodigo() + " | \t");
                System.out.print(livros[j].getCategoria().getNome() + " | \t");
                System.out.println();
            }
        }
    }

    // INTERFACE
     /* Métodos que fazem parte do funcionamento da interface.
    Interações com a classe Livro. 
     */
    public void realizarAcoesLivros(Database database,
                                            Scanner entrada,
                                            LivroDb livroDb,
                                            LivroView livroView,
                                            CategoriaDb categoriaDb,
                                            CategoriaView categoriaView) throws Exception {
        // Realizar ações relacionadas aos livros
        int opcao = -1; //porque é diferente de 0 e é diferente das opções apresentada no menu

        while (opcao != 0) {
            System.out.println("======= Menu Livros ========");
            System.out.println("1 - Visualizar Livros");
            System.out.println("2 - Criar Livro");
            System.out.println("3 - Alterar Livros");
            System.out.println("4 - Deletar Livros");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("===========================");

            opcao = entrada.nextInt();


            switch (opcao) {
                // PRIMEIRA OPÇÃO VISUALIZAR LIVROS
                case 1:
                    visualizarLivrosInterface(database, livroDb, livroView);
                    break;
                // SEGUNDA OPÇÃO CRIAR LIVROS
                case 2:
                    criarLivroInterface(database, entrada, livroDb, categoriaDb, categoriaView);
                    break;
                // TERCEIRA OPÇÃO ALTERAR LIVROS
                case 3:
                    alterarLivroInterface(database, entrada, livroDb);
                    break;
                // QUARTA OPÇÃO DELETAR LIVROS
                case 4:
                    deletarLivroInterface(database, entrada, livroDb);
                    break;
                // VOLTAR AO MENU ANTERIOR
                case 0:
                    System.out.println("Voltando ao menu anterior.......");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public void visualizarLivrosInterface(Database database,
                                         LivroDb livroDb,
                                         LivroView livroView) throws Exception {
        // Exibir lista de livros
        Livro[] livros = livroDb.lerLivros();
        livroView.mostrarLivros(livros);
    }

    public void criarLivroInterface(Database database,
                                   Scanner entrada,
                                   LivroDb livroDb,
                                   CategoriaDb categoriaDb,
                                   CategoriaView categoriaView) throws Exception {
        // Criar um novo livro
        // Precisa mostrar categorias antes:
        Categoria[] categorias = categoriaDb.lerCategorias();
        categoriaView.mostrarCategorias(categorias);
        entrada.nextLine();
        System.out.println("Digite o nome do livro: ");
        String titulo = entrada.nextLine();
        System.out.println("Digite o nome do autor: ");
        String autor = entrada.nextLine();
        // precisa saber o tamanho do vetor
        System.out.println("Digite quantas categorias ele tem:");
        int tamanho = entrada.nextInt();

        int[] codigosCategoria = new int[tamanho];
        System.out.println("Digite o código da categoria: ");
        for (int i = 0; i < tamanho; i++) {
            codigosCategoria[i] = entrada.nextInt();
        }
        livroDb.criarLivro(titulo, autor, codigosCategoria);
    }

    public void alterarLivroInterface(Database database,
                                     Scanner entrada,
                                     LivroDb livroDb) throws Exception {
        // Alterar informações de um livro existente
        System.out.println("Digite o código do livro que deseja alterar: ");
        int codigoLivro = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o novo nome do livro: ");
        String novoTitulo = entrada.nextLine();
        System.out.println("Digite o novo nome do autor: ");
        String novoAutor = entrada.nextLine();
        livroDb.alterarLivro(codigoLivro, novoTitulo, novoAutor);
    }

    public void deletarLivroInterface(Database database,
                                     Scanner entrada,
                                     LivroDb livroDb) throws Exception {
        // Deletar um livro existente
        System.out.println("Digite o código do livro que deseja excluir: ");
        int codigoLivro = entrada.nextInt();
        livroDb.deletarLivro(codigoLivro);
    }

    public void pesquisarLivrosInterface(Database database,
                                         Scanner entrada,
                                         LivroDb livroDb,
                                         LivroView livroView) throws Exception {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("======= Menu Pesquisa Livros ========");
            System.out.println("Você deseja pesquisar um livro por:");
            System.out.println("1 - Título");
            System.out.println("2 - Categoria");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("====================================");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                // PRIMEIRA OPÇÃO VISUALIZAR PESQUISA POR TÍTULO
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    String tituloLivro = entrada.nextLine();
                    Livro[] livrosPorTitulo = livroDb.filtroLivrosTitulo(tituloLivro);
                    livroView.mostrarFiltroPorTítulo(livrosPorTitulo);
                    break;
                // SEGUNDA OPÇÃO VISUALIZAR PESQUISA POR CATEGORIA
                case 2:
                    System.out.println("Digite a categoria desejada: ");
                    String categoria = entrada.nextLine();
                    Livro[] livrosPorcategorias = livroDb.filtroLivrosCategoria(categoria);
                    livroView.mostrarFiltroPorCategoria(livrosPorcategorias);
                    break;
                // VOLTAR AO MENU ANTERIOR
                case 0:
                    System.out.println("Voltando ao menu anterior.......");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

}
