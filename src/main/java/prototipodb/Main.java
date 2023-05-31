package prototipodb;

import prototipodb.database.*;
import prototipodb.model.Categoria;
import prototipodb.view.CategoriaView;
import prototipodb.model.Livro;
import prototipodb.view.LivroView;

public class Main {
    public static void main(String[] args) throws Exception {
        String username = "root";
        String password = "rootroot";
        String databaseName = "BIBLIOTECA";
        String serverName = "localhost";

        Database database = new Database(serverName, databaseName, password, username);

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
        BibliotecariaDb bibliotecariaDb = new BibliotecariaDb(database);
        // criar Bibliotecaria:
        // bibliotecariaDb.criarBibliotecaria("Katerine Witkoski", "11111111111", "katerinewitkoski@email.com");
        // - Alterar Bibliotecaria:
        // bibliotecariaDb.alterarBibliotecaria("Katerine Witkoski novo", "katerinewitkoskinovo@email.com", "11111111111");
        // Deletar leitor:
        // bibliotecariaDb.deletarBibliotecaria("11111111111");

    }
}

