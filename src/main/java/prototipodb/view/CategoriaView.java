package prototipodb.view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import prototipodb.database.CategoriaDb;
import prototipodb.database.Database;
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

    // CATEGORIAS INTERFACE:
    public void realizarAcoesCategorias(Database database,
                                                Scanner entrada,
                                                CategoriaDb categoriaDb,
                                                CategoriaView categoriaView) throws Exception {
        // Realizar ações relacionadas às categorias
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Você selecionou as opções de Categorias");
            System.out.println("============ Menu Categorias ===========");
            System.out.println("1 - Visualizar");
            System.out.println("2 - Criar");
            System.out.println("3 - Alterar");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("=======================================");

            opcao = entrada.nextInt();

            switch (opcao) {
                // PRIMEIRA OPÇÃO VISUALIZAR CATEGORIAS
                case 1:
                    visualizarCategoriasInterface(
                            database,
                            categoriaDb,
                            categoriaView
                    );
                    break;
                // SEGUNDA OPÇÃO CRIAR CATEGORIA
                case 2:
                    criarCategoriasInterface(
                            database,
                            entrada,
                            categoriaDb
                    );
                    break;
                // TERCEIRA OPÇÃO ALTERAR CATEGORIA
                case 3:
                    alterarCategoriasInterface(
                            database,
                            entrada,
                            categoriaDb
                    );
                    break;
                // VOLTAR AO MENU ANTERIOR
                case 0:
                    System.out.println("Voltando ao menu anterior.......");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public static void visualizarCategoriasInterface(Database database,
                                     CategoriaDb categoriaDb,
                                     CategoriaView categoriaView) throws Exception {
        Categoria[] categorias = categoriaDb.lerCategorias();
        categoriaView.mostrarCategorias(categorias);
    }

    public static void criarCategoriasInterface(Database database, Scanner entrada, CategoriaDb categoriaDb) throws Exception {
        entrada.nextLine();
        System.out.println("Digite a nova categoria: ");
        String novaCategoria = entrada.nextLine();
        categoriaDb.criarCategoria(novaCategoria);
    }

    public static void alterarCategoriasInterface(Database database, Scanner entrada,  CategoriaDb categoriaDb) throws Exception{
        System.out.println("Nome da nova categoria: ");
        entrada.nextLine();
        String novaCategoria = entrada.nextLine();
        System.out.println("Código para alterar a categoria: ");
        int codigo = entrada.nextInt();
        categoriaDb.alterarCategoria(novaCategoria, codigo);
    }


}
