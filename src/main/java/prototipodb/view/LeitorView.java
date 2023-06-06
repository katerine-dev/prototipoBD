package prototipodb.view;

public class LeitorView {
    public void opcaoLeitor(Database database, Scanner entrada) throws Exception {
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

            LeitorDb leitorDb = new LeitorDb(database);

            switch (opcaoLeitor) {
                case 1:
                    alterarLeitor(leitorDb, entrada);
                    break;
                case 2:
                    deletarLeitor(leitorDb, entrada);
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
