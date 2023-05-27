package prototipodb.view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import prototipodb.model.Categoria;


public class CategoriaView {
    public void mostrarCategorias(Categoria[] categorias) {

        String[] cabecalho = {"Código", "Nome"};

        // Imprimindo cabeçalho da tabela
        for (int i = 0; i < cabecalho.length; i++) {
            System.out.print(cabecalho[i] + "\t"); // caractere de tabulação
        }
        System.out.println();
        // Imprimindo as linhas da tabela
        int j = 0;
        while(categorias[j] != null){
            System.out.print(categorias[j].getCodigo() + "\t");
            System.out.println(categorias[j].getNome() + "\t");
            j = j + 1;
        }

    }

}
