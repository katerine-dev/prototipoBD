package prototipodb.model;
/*
Atributos:
- Nome (String)
- RA (String)
- email (String)
 */
public class Leitor extends Usuario {
    public String RA;

    // Método construtor:
    public Leitor(String nome, String email, String RA){
        super(nome, email);
        this.RA = RA;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }
}
