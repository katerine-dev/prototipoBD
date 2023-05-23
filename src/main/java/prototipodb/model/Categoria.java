package prototipodb.model;
/*
Atributos:
- Nome
- Código
 */

public class Categoria {
    public int codigo;
    public String nome;

    // Método construtor:
    public Categoria(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }
}