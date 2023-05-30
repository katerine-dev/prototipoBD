package prototipodb.model;

/*
Atributos:
- Nome (String)
- email (String)
 */

public class Usuario {
    private String nome;
    private String email;

    // Método construtor
    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
