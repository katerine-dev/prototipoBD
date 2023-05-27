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
- Criar (CREATE) - ok
- Alterar (UPDATE)
- Apagar (DELETE - excluir livro danificado) - ok
- Imprimir (SELECT)
 */

import prototipodb.model.Categoria;
import prototipodb.model.Livro;

public class LivroDb {
    private Database database;

    public LivroDb(Database database){
        this.database = database;
    }

    // int[] codigosCategoria vetor para passar várias categorias

    public void criarLivro(String titulo, String autor, int[] codigosCategoria) throws Exception {
        // primeiro INSERT na tabela Livro - preciso fazer o INSERT retornar o ID.
        String sqlLivros = "INSERT INTO livros (nome_livro, autor_livro) VALUES (?, ?)";
        // O prepareStatement quero que você me retorne as chaves que você gerar: (Vai ajudar criar o livroCategoria)
        PreparedStatement instrucaoLivros = this.database.getConnection().prepareStatement(sqlLivros, Statement.RETURN_GENERATED_KEYS);

        // Definir os valores dos parâmetros
        instrucaoLivros.setString(1, titulo);
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

    public void deletarLivro(int codigoLivro) throws Exception {
        // Primeiro precisa excluir da tabela LIVROSCATEGORIA:
        String sqlLivrosCategoria = "DELETE FROM livrosCategoria WHERE cod_livro = (?)";
        PreparedStatement instrucaoLivrosCategoria = this.database.getConnection().prepareStatement(sqlLivrosCategoria);

        // Definir os valores dos parâmetros
        instrucaoLivrosCategoria.setInt(1, codigoLivro);

        // Executar a instrução SQL da variável `instrucao`
        instrucaoLivrosCategoria.executeUpdate();

        // Para excluir em LIVROS:

        String sqlLivros = "DELETE FROM livros WHERE cod_livro = (?)";
        PreparedStatement instrucaoLivros = this.database.getConnection().prepareStatement(sqlLivros);

        // Definir os valores dos parâmetros
        instrucaoLivros.setInt(1, codigoLivro);

        // Executar a instrução SQL da variável `instrucao`
        instrucaoLivros.executeUpdate();


        System.out.println("Livro removido!");

    }
    public Livro[] lerLivros() throws Exception {
        int maximoNumeroDeResultados = 100;
        String sql = "SELECT lc.cod_livro, l.nome_livro, l.autor_livro, lc.cod_categoria, c.nome_categoria " +
                "FROM livrosCategoria lc " +
                "JOIN livros l ON lc.cod_livro = l.cod_livro " +
                "JOIN categoria c ON lc.cod_categoria = c.cod_categoria " +
                "LIMIT " +  maximoNumeroDeResultados;
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Executar a instrução SQL da variável `instrucao`
        ResultSet resultados = instrucao.executeQuery(sql);
        Livro[] livros = new Livro[maximoNumeroDeResultados];

        int i = 0;
        while (resultados.next()) {
            int codigoLivro = resultados.getInt(1);
            String titulo = resultados.getString(2);
            String nomeAutor = resultados.getString(3);
            int codigoCategoria = resultados.getInt(4);
            String nomeCategoria = resultados.getString(5);

            Categoria categoria = new Categoria(codigoCategoria, nomeCategoria);
            Livro livro = new Livro(codigoLivro, titulo, nomeAutor, categoria);
            livros[i] = livro;
            i = i + 1;
        }

        return livros;
    }
    // Criar alterar livro
}
