package prototipodb;

import prototipodb.database.CategoriaDb;
import prototipodb.database.Database;
import prototipodb.database.LivroDb;

public class Main {
    public static void main(String[] args) throws Exception {
        String username = "root";
        String password = "rootroot";
        String databaseName = "BIBLIOTECA";
        String serverName = "localhost";

        Database database = new Database(serverName, databaseName, password, username);

        // interações com a tabela categorias:
        CategoriaDb categoriaDb = new CategoriaDb(database);

        //TESTES DE INTERAÇÃO COM BANCO DE DADOS:
        // Criar categoria:
        // categoriaDb.criarCategoria("Terror");
        // Alterar categoria:
        // categoriaDb.alterarCategoria("Infantil", 1);
        // Mostrar categoria:
        // categoriaDb.mostrarCategorias("categoria");

        // interações com a tabela livros e livros categorias:
        // LivroDb livroDb = new LivroDb(database);
        // livroDb.criarLivro("Orgulho e Preconceito", "Jane Austen", new int[] {1,2});


    }
}

