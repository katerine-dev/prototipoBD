package prototipodb.model;
/*
Atributos:
- Nome (String)
- RA (long)
 */
public class Leitor extends Usuario {
    public long RA;

    // Método construtor:
    public Leitor(String nome, long RA){
        super(nome);
        this.RA = RA;
    }
}
