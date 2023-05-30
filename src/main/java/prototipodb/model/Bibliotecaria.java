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
    public Bibliotecaria(String nome, String email, String CPF){
        super(nome, email);
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = this.CPF;
    }

}
