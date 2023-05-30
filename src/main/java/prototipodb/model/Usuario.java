package prototipodb.model;

/*
Atributos:
- Nome
- CPF
 */

public class Usuario {
    private String nome;
    private int[] CPF;

    // Método construtor
    public Usuario(){
        this.CPF = 0;
        this.nome = "";
    }
    // Polimorfismo:
    public Usuario(String nome){
        this.nome = nome;
        this.CPF = 0;
    }

    public Usuario(String nome, int[] CPF){
        this.nome = nome;
        this.CPF = validaCPF(CPF);
    }

    public boolean validaCPF(int[] CPF){
        // Verificando se o CPF possui 11 dígitos
        if (CPF.length() != 11) {
            return false;
        }
        return CPF;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = this.validaCPF(CPF);
    }
}
