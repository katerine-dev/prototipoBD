package prototipodb.model;
/*
Atributos:
- Nome
- email
- CPF
 */
public class Bibliotecaria extends Usuario {
    private String CPF;
    // Método construtor:
    public Leitor(String nome, String email, String CPF){
        super(nome, email);
        this.CPF = validaCPF(CPF);
    }

    public boolean validaCPF(String CPF){
        // Verificando se o CPF possui 11 dígitos
        if (CPF.length() != 11) {
            return false;
        }
        return CPF;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = this.validaCPF(CPF);
    }

}
