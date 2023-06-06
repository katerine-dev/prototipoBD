package prototipodb.view;

import prototipodb.database.*;
import java.util.Scanner;

public class BibliotecariaView {

    public void opcaoBibliotecario(Database database,
                                    Scanner entrada,
                                    BibliotecariaDb bibliotecariaDb) throws Exception {
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

            switch (opcaoBibliotecaria) {
                case 1:
                    alterarBibliotecariaInterface(database, entrada, bibliotecariaDb);
                    break;
                case 2:
                    deletarBibliotecariaInterface(database, entrada, bibliotecariaDb);
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

    public void alterarBibliotecariaInterface(Database database, Scanner entrada, BibliotecariaDb bibliotecariaDb) throws Exception {
        System.out.println("Digite o novo nome da bibliotecária: : ");
        String novoNome = entrada.nextLine();
        System.out.println("Digite o novo email: ");
        String novoEmail = entrada.nextLine();
        System.out.println("Digite o novo CPF: ");
        String CPF = entrada.nextLine();
        bibliotecariaDb.alterarBibliotecaria(novoNome,novoEmail, CPF);
    }

    public void deletarBibliotecariaInterface(Database database, Scanner entrada, BibliotecariaDb bibliotecariaDb) throws Exception {
        System.out.println("Digite o CPF que deseja deletar: ");
        String CPF = entrada.nextLine();
        bibliotecariaDb.deletarBibliotecaria(CPF);
    }

}
