package prototipodb;

import prototipodb.database.CategoriaDb;
import prototipodb.database.Database;
import prototipodb.database.LivroDb;
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

        // interações com a tabela categorias:
        CategoriaDb categoriaDb = new CategoriaDb(database);
        CategoriaView categoriaView = new CategoriaView();

        // CATEGORIA: ____________________________________

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
        Livro[] livros = livroDb.lerLivros();

        // - Imprime categorias:
        livroView.mostrarLivros(livros);

    }
}

