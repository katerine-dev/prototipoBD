package prototipodb.view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import prototipodb.model.Categoria;


public class CategoriaView {

    /* Método para visualizar a tabela Categoria: (método dependente do lerCategorias())
    Inicialmente passamos um vetor com todos os nomes de colunas já existentes na tabela livros imprimindo
    o cabeçalho.
    Após utilizando o vetor criado em lerCategorias(), imprimimos linha por linha, tabelando as informações.
    */
    public void mostrarCategorias(Categoria[] categorias) {

        String[] cabecalho = {"Código", "Nome"};

        // Imprimindo cabeçalho da tabela
        for (int i = 0; i < cabecalho.length; i++) {
            System.out.print(cabecalho[i] + "\t"); // caractere de tabulação
        }
        System.out.println();
        // Imprimindo as linhas da tabela
        for (int j = 0; j < categorias.length; j++){
            System.out.print(categorias[j].getCodigo() + "\t");
            System.out.println(categorias[j].getNome() + "\t");
        }
    }
}
