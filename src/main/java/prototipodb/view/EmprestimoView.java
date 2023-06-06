package prototipodb.view;

import prototipodb.database.Database;
import prototipodb.database.EmprestimoDb;
import prototipodb.model.Emprestimo;

import java.util.Scanner;

public class EmprestimoView {

    /* Método para visualizar a tabela Emprestimo: (método dependente do lerEmprestimo())
    Inicialmente passamos um vetor com todos os nomes de colunas já existentes na tabela livros imprimindo
    o cabeçalho.
    Após utilizando o vetor criado em lerEmprestimo(), imprimimos linha por linha, tabelando as informações.
    */
    public void mostrarEmprestimos(Emprestimo[] emprestimos) {

        String[] cabecalho = {"Código livro", "Status", "RA leitor"};

        // Imprimindo cabeçalho da tabela
        for (int i = 0; i < cabecalho.length; i++) {
            System.out.print(cabecalho[i] + "\t"); // caractere de tabulação
        }
        System.out.println();
        // Imprimindo as linhas da tabela
        for (int j = 0; j < emprestimos.length; j++){
            System.out.print(emprestimos[j].getCodigoLivro() + " | \t");
            System.out.print(emprestimos[j].statusLivro + " | \t");
            System.out.print(emprestimos[j].raLeitor + " | \t");
            System.out.println();
        }
    }
    // EMPRESTIMO INTERFACE
     /* Métodos que fazem parte do funcionamento da interface.
    Interações com a classe emprestimo. 
     */
    public void realizarAcoesEmprestimos(Database database,
                                         Scanner entrada,
                                         EmprestimoDb emprestimoDb,
                                         EmprestimoView emprestimoView) throws Exception {
        // Realizar ações relacionadas aos empréstimos
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Você selecionou as opções de Emprestimos.");
            System.out.println("=========== Menu Emprestimos ============");
            System.out.println("1 - Visualizar");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("=========================================");

            opcao = entrada.nextInt();
            switch (opcao) {
                // PRIMEIRA OPÇÃO VISUALIZAR EMPRESTIMOS
                case 1:
                    Emprestimo[] emprestimos = emprestimoDb.lerEmprestimo();
                    emprestimoView.mostrarEmprestimos(emprestimos);
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
    
    public void realizarEmprestimoInterface(Database database,
                                         Scanner entrada,
                                         EmprestimoDb emprestimoDb) throws Exception {
        System.out.println("Digite o seu RA: ");
        String RA = entrada.nextLine();
        System.out.println("Digite o código do livro que você quer alugar: ");
        int codigoLivro = entrada.nextInt();
        emprestimoDb.reservarLivro(RA, codigoLivro);
    }

    public void devolverLivroInterface(Database database,
                                            Scanner entrada,
                                            EmprestimoDb emprestimoDb) throws Exception {
        System.out.println("Digite o seu RA: ");
        String RA = entrada.nextLine();
        entrada.nextLine();
        System.out.println("Digite o código do livro que você quer devolver: ");
        int codigoLivro = entrada.nextInt();
        emprestimoDb.devolverLivro(codigoLivro, RA);
    }
}
