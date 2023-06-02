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
- Alterar (UPDATE) - ok
- Apagar (DELETE - excluir livro danificado) - ok
- Imprimir (SELECT) - ok
- Filtro por livro - ok
- Filtro por categoria - ok
 */

import prototipodb.model.Categoria;
import prototipodb.model.Livro;

public class LivroDb {
    private Database database;

    public LivroDb(Database database){
        this.database = database;
    }

    /* Método para criar livro usando uma conexão MySQL:
    criarLivro recebe informações de título de livro, autor e os códigos da caregoria correspondente,
    já existente na tabela 'categoria'.
    int[] codigosCategoria vetor para passar várias categorias (relação n:n = um livro pode ter mais de uma categoria,
    uma categoria pode ter mais de um livro)
    */
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


        // e depois INSERT na tabela livroCategoria - adaptando para relacionar categorias com livros:
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

    /* Método para alterar livro usando uma conexão MySQL:
    alterarLivro recebe informações de codigo livro para autor ser possível dar UPDATE novo título e novo autor.
    O usuário precisa indicar qual é o novo título e o novo nome de autor.
    */
    public void alterarLivro(int codigoLivro, String novoTitulo, String novoAutor) throws Exception {
        String sql = "UPDATE livros SET nome_livro = ?, autor_livro = ? WHERE cod_livro = ?";
        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Definir os valores dos parâmetros
        instrucao.setInt(3, codigoLivro);
        instrucao.setString(1, novoTitulo);
        instrucao.setString(2, novoAutor);

        // Executar a instrução SQL da variável `instrucao`
        instrucao.executeUpdate();

        System.out.println("Livro alterado!");
    }

    /* Método para deletar livro usando uma conexão MySQL:
    Em caso do livro ser danificado conseguimos deletar ele dos registros, para isso acontecer precisamos
    deletar primeiro na tabela livrosCategoria (por ser uma tabela relacional, somente com os Primary keys.
    para depois deletar da tabela livros.
    */
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

    /* Método para ler livro usando uma conexão MySQL: (método que auxilia o mostrarLivros())
    Inicialmente precisamos definir um vetor para atribuir um LIMIT no SELECT/JOIN.
    E com os resultados da query atribuir os valores no novo vetor.
    */
    public Livro[] lerLivros() throws Exception {
        // Preciso definir o tamanho do vetor
        String sqlCountCategorias = "SELECT count(*) FROM livrosCategoria";
        PreparedStatement instrucaoCountCategorias = this.database.getConnection().prepareStatement(sqlCountCategorias);
        ResultSet resultadosCountCategorias = instrucaoCountCategorias.executeQuery(sqlCountCategorias);
        resultadosCountCategorias.next();
        int maximoNumeroDeResultados = resultadosCountCategorias.getInt(1);

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

    /* Método para filtrar a busca de usuário por título da tabela livro usando uma conexão MySQL:
    (método que auxilia o mostrarFiltroPorTítuloLivros())
    Inicialmente precisamos definir um vetor para atribuir um LIMIT no SELECT/JOIN.
    E com os resultados da query atribuir os valores no novo vetor.
     */
    public Livro[] filtroLivrosTitulo(String titulo) throws Exception {
        // Preciso definir o tamanho do vetor
        String sqlCountLivros = "SELECT count(*) FROM livros";
        PreparedStatement instrucaoCountLivros = this.database.getConnection().prepareStatement(sqlCountLivros);
        ResultSet resultadosCountLivros = instrucaoCountLivros.executeQuery(sqlCountLivros);
        resultadosCountLivros.next();
        int maximoNumeroDeResultados = resultadosCountLivros.getInt(1);

        Livro[] livrosEncontrados = new Livro[maximoNumeroDeResultados];

        // Filtro por título:
        // % permite buscar registros em que o título contenha o texto pesquisado em qualquer posição.
        // encontrando resultados que possam ter o texto pesquisado em qualquer parte do título
        String sql = "SELECT cod_livro, nome_livro, autor_livro " +
                "FROM livros " +
                "WHERE nome_livro LIKE CONCAT('%','" + titulo + "', '%')";

        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Executar a instrução SQL da variável `instrucao`
        ResultSet resultados = instrucao.executeQuery(sql);

        int i = 0;
        while (resultados.next()) {
            int codigoLivro = resultados.getInt("cod_livro");
            String nometitulo = resultados.getString("nome_livro");
            String nomeAutor = resultados.getString("autor_livro");

            Livro livro = new Livro(codigoLivro, nometitulo, nomeAutor, null);
            livrosEncontrados[i] = livro;
            i = i + 1;
        }
        return livrosEncontrados;
        // incluir mensagem de não encontrado o livro.
    }

    /* Método para filtrar a busca de usuário por categoria da tabela livro usando uma conexão MySQL:
    (método que auxilia o mostrarFiltroPorCategoria())
    Inicialmente precisamos definir um vetor para atribuir um LIMIT no SELECT/JOIN.
    E com os resultados da query atribuir os valores no novo vetor.
    */
    public Livro[] filtroLivrosCategoria(String categoria) throws Exception {
        // Preciso definir o tamanho do vetor
        String sqlCountLivrosCategoria = "SELECT count(*) FROM livrosCategoria";
        PreparedStatement instrucaoCountLivrosCategoria = this.database.getConnection().prepareStatement(sqlCountLivrosCategoria);
        ResultSet resultadosCountLivrosCategoria = instrucaoCountLivrosCategoria.executeQuery(sqlCountLivrosCategoria);
        resultadosCountLivrosCategoria.next();
        int maximoNumeroDeResultados = resultadosCountLivrosCategoria.getInt(1);

        Livro[] livrosEncontrados = new Livro[maximoNumeroDeResultados];

        // Filtro por título:
        // % permite buscar registros em que o título contenha o texto pesquisado em qualquer posição.
        // encontrando resultados que possam ter o texto pesquisado em qualquer parte do título
        String sql = "SELECT lc.cod_livro, l.nome_livro, l.autor_livro, lc.cod_categoria, c.nome_categoria " +
                "FROM livrosCategoria lc " +
                "JOIN livros l ON lc.cod_livro = l.cod_livro " +
                "JOIN categoria c ON lc.cod_categoria = c.cod_categoria " +
                "WHERE nome_categoria LIKE CONCAT('%','" + categoria + "', '%')";

        PreparedStatement instrucao = this.database.getConnection().prepareStatement(sql);

        // Executar a instrução SQL da variável `instrucao`
        ResultSet resultados = instrucao.executeQuery(sql);

        int i = 0;
        while (resultados.next()) {
            int codigoLivro = resultados.getInt(1);
            String nomeTitulo = resultados.getString(2);
            String nomeAutor = resultados.getString(3);
            int codigoCategoria = resultados.getInt(4);
            String nomeCategoria = resultados.getString(5);

            Categoria categorias = new Categoria(codigoCategoria, nomeCategoria);
            Livro livro = new Livro(codigoLivro, nomeTitulo, nomeAutor, categorias);
            livrosEncontrados[i] = livro;
            i = i + 1;
        }
        return livrosEncontrados;

    }
}
