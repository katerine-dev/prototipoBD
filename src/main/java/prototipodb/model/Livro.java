package prototipodb.model;
/*
Atributos:
- Nome
- Autor
- código Livros
- Categoria
*/
public class Livro {
    public int codigo;
    public String nome;
    public String autor;
    public Categoria categoria;

    // Método construtor:

    public Livro(int codigo, String nome, String autor, Categoria categoria){
        this.codigo = codigo;
        this.nome = nome;
        this.autor = autor;
        this.categoria = categoria;
    }
}
