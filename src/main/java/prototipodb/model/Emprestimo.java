package prototipodb.model;
/*
Atributos:
- Codigo Livro
- Nome
- Autor
- Status (String - somente 3 possíveis - Reservado/Excluído/Disponível)
- Nome Leitor
*/

public class Emprestimo {
    public Livro codigo;
    public Livro nome;
    public Livro autor;
    public String status;
    public Leitor nomeLeitor;

    // Método construtor:
    public Emprestimo(Livro codigo,
                      Livro nome,
                      Livro autor,
                      String status,
                      Leitor nomeLeitor){
        this.codigo = codigo;
        this.nome = nome;
        this.autor = autor;
        this.status = status;
        this.nomeLeitor = nomeLeitor;
    }

}
