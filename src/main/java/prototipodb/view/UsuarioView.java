package prototipodb.view;
import prototipodb.database.*;
import java.util.Scanner;

public class UsuarioView {
    // INTERFACE
     /* Métodos que fazem parte do funcionamento da interface.
    Interações com a classe Usuário. 
     */
    public void realizarAcoesUsuarios(Database database,
                                      Scanner entrada,
                                      BibliotecariaView bibliotecariaView,
                                      LeitorView leitorView,
                                      BibliotecariaDb bibliotecariaDb,
                                      LeitorDb leitorDb) throws Exception {

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
                    case 1:
                        bibliotecariaView.opcaoBibliotecario(
                            database,
                            entrada,
                            bibliotecariaDb
                        );

                        break;
                    case 2:
                        leitorView.opcaoLeitor(
                                database,
                                entrada,
                                leitorDb
                        );
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
