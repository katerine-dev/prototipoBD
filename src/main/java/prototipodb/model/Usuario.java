package prototipodb.model;
/*
Atributos:
- Nome (String)
- RA (long)
 */
public class Usuario {
    public String nome;
    public long RA;

    // Método construtor:
    public Usuario(String nome, long RA){
        this.nome = nome;
        this.RA = RA;
    }
}
