package prototipodb.database;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
Atributos:
- Nome (String)
- Autor (String)
- código Livros (Chave primária - int)
- Categoria (Chave estrangeira da tabela categorias - int)

Métodos:
- Criar (CREATE)
- Alterar (UPDATE)
- Apagar (DELETE - excluir livro danificado)
- Ler e imprimir (READ)
 */

import prototipodb.model.Categoria;

public class LivroDb {
    private Database database;

    public LivroDb(Database database){
        this.database = database;
    }

    // int[] codigosCategoria vetor para passar várias categorias

    public void criarLivro(String nome, String autor, int[] codigosCategoria) throws Exception {
        // primeiro INSERT na tabela Livro - preciso fazer o INSERT retornar o ID.
        String sqlLivros = "INSERT INTO livros (nome_livro, autor_livro) VALUES (?, ?)";
        // O prepareStatement quero que você me retorne as chaves que você gerar: (Vai ajudar criar o livroCategoria)
        PreparedStatement instrucaoLivros = this.database.getConnection().prepareStatement(sqlLivros, Statement.RETURN_GENERATED_KEYS);

        // Definir os valores dos parâmetros
        instrucaoLivros.setString(1, nome);
        instrucaoLivros.setString(2, autor);

        instrucaoLivros.executeUpdate();

        // Executar a instrução SQL da variável `instrucao`
        // ResultSet é uma classe que armazena os resultados do banco:
        ResultSet generatedKeys = instrucaoLivros.getGeneratedKeys(); // retorna o ID
        generatedKeys.next(); // next = booleno que me ajuda interar o próximo.
        int codigoLivro = generatedKeys.getInt(1); // Me retorna o cógigo gerado. (AUTOINCREMENT - id gerado no próprio banco)


        // livroCategoria - adaptando para relacionar categorias com livros:

        String sqlLivrosCategoria = "INSERT INTO livrosCategoria (cod_livro, cod_categoria) VALUES (?, ?)";
        PreparedStatement instrucaoLivrosCategoria = this.database.getConnection().prepareStatement(sqlLivrosCategoria);

        for (int i = 0; i < codigosCategoria.length;i++){
            instrucaoLivrosCategoria.setInt(1, codigoLivro);
            instrucaoLivrosCategoria.setInt(2, codigosCategoria[i]);
            instrucaoLivrosCategoria.executeUpdate(); // executar a query
        }
        // Supondo que o usuário sempre irá digitar um código de categoria válido.

        System.out.println("Livro Criado!");
    }

    // Criar alterar livro
    // Criar Deletar livro
}
