package prototipodb.view;

import prototipodb.database.*;
import java.util.Scanner;

public class LeitorView {
    public void opcaoLeitor(Database database,
                            Scanner entrada,
                            LeitorDb leitorDb) throws Exception {
        int opcaoLeitor = 1;

        while (opcaoLeitor != 0) {
            System.out.println("Você selecionou as opções de Leitor");
            System.out.println("=========== Menu Leitor ===========");
            System.out.println("1 - Alterar");
            System.out.println("2 - Deletar");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("===================================");

            opcaoLeitor = entrada.nextInt();
            entrada.nextLine();

            switch (opcaoLeitor) {
                case 1:
                    alterarLeitorInterface(database,entrada, leitorDb);
                    break;
                case 2:
                    deletarLeitorInterface(database, entrada, leitorDb);
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

    public void alterarLeitorInterface(Database database, Scanner entrada, LeitorDb leitorDb) throws Exception {
        System.out.println("Digite o nome do novo leitor: ");
        String novoNome = entrada.nextLine();
        System.out.println("Digite o novo email do leitor: ");
        String novoEmail = entrada.nextLine();
        System.out.println("Digite o novo RA do leitor: ");
        String RA = entrada.nextLine();
        leitorDb.alterarLeitor(novoNome,RA, novoEmail);
    }

    public void deletarLeitorInterface(Database database, Scanner entrada, LeitorDb leitorDb) throws Exception {                                                    System.out.println("Digite o RA do leitor que deseja deletar: ");
        String RA = entrada.nextLine();
        leitorDb.deletarLeitor(RA);
    }
}
