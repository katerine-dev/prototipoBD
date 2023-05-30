package prototipodb.model;
/*
Atributos:
- Nome (String)
- RA (long)
- email (String)
 */
public class Leitor extends Usuario {
    public long RA;

    // Método construtor:
    public Leitor(String nome, String CPF, long RA){
        super(nome, CPF);
        this.RA = RA;
    }

    public long getRA() {
        return RA;
    }

    public void setRA(long RA) {
        this.RA = RA;
    }
}
