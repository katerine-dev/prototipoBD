package prototipodb.view;

import prototipodb.model.Livro;


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
}
