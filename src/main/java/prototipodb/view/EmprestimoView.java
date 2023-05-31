package prototipodb.view;

import prototipodb.database.EmprestimoDb;
import prototipodb.model.Emprestimo;

public class EmprestimoView {
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
}
