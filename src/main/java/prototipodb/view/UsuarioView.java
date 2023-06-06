package prototipodb.view;

import prototipodb.database.Database;

import java.util.Scanner;

public class UsuarioView {
    // USUARIO:
    public void realizarAcoesUsuarios(Database database, Scanner entrada) throws Exception {

        int opcao = -1;
        while (opcao != 0) {
            // Realizar ações relacionadas aos usuários
            System.out.println("===== Menu usuário ========");
            System.out.println("Você selecionou usuário");
            System.out.println("1 - Bibliotecario");
            System.out.println("2 - Leitor");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("===========================");

            opcao = entrada.nextInt();
            switch (opcao) {
                switch (opcao) {
                    case 1:
                        opcaoBibliotecario(database, entrada);
                        break;
                    case 2:
                        opcaoLeitor(database, entrada);
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
}
