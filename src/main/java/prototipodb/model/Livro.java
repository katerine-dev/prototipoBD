package prototipodb.model;
/*
Atributos:
- Titulo
- Autor
- código Livros
- Categoria
*/
public class Livro {
    public int codigo;
    public String titulo;
    public String autor;
    public Categoria categoria;

    // Método construtor:

    public Livro(int codigo, String titulo, String autor, Categoria categoria){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }
}
