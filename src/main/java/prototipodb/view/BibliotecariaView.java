package prototipodb.view;

import prototipodb.database.BibliotecariaDb;
import prototipodb.database.Database;
import prototipodb.database.LeitorDb;

import java.util.Scanner;

public class BibliotecariaView {

    private void opcaoBibliotecario(Database database, Scanner entrada) throws Exception {
        int opcaoBibliotecaria = 1;

        while (opcaoBibliotecaria != 0) {
            System.out.println("Você selecionou as opções de Bibliotecaria");
            System.out.println("============= Menu Bibliotecario =========");
            System.out.println("1 - Alterar");
            System.out.println("2 - Deletar");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("==========================================");

            opcaoBibliotecaria = entrada.nextInt();
            entrada.nextLine();

            BibliotecariaDb bibliotecariaDb = new BibliotecariaDb(database);

            switch (opcaoBibliotecaria) {
                case 1:
                    alterarBibliotecaria(bibliotecariaDb, entrada);
                    break;
                case 2:
                    deletarBibliotecaria(bibliotecariaDb, entrada);
                    break;
                case 0:
                    System.out.println("Voltando ao menu anterior.......");
                    break;
                default:
                    System.out.println("opção inválida");
                    break;
            }
        }
    }

}
