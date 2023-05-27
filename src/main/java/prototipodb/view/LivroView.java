package prototipodb.view;

import prototipodb.model.Livro;

public class LivroView {
    public void mostrarLivros(Livro[] livros) {

        String[] cabecalho = {"Código Livro", "Título", " Autor", "Código Categoria", "Nome Categoria"};

        // Imprimindo cabeçalho da tabela
        for (int i = 0; i < cabecalho.length; i++) {
            System.out.print(cabecalho[i] + "\t"); // caractere de tabulação
        }
        System.out.println();
        // Imprimindo as linhas da tabela
        int j = 0;
        while(livros[j] != null){
            System.out.print(livros[j].getCodigo() + " | \t");
            System.out.print(livros[j].getTitulo() + " | \t");
            System.out.print(livros[j].getAutor() + " | \t");
            System.out.print(livros[j].getCategoria().getCodigo() + " | \t");
            System.out.print(livros[j].getCategoria().getNome() + " | \t");
            System.out.println();
            j = j + 1;
        }

    }
}
