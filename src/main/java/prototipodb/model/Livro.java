package prototipodb.model;
/*
Atributos:
- Titulo
- Autor
- código Livros
- Categoria
*/
public class Livro {
    private int codigo;
    private String titulo;
    private String autor;
    private String categoria;

    // Método construtor:

    public Livro(int codigo, String titulo, String autor, Categoria categoria){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
