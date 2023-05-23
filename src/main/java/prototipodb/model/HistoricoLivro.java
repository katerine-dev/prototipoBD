package prototipodb.model;
/*
Atributos:
- Codigo Livro
- Nome
- Autor
- Status (String - somente 3 possíveis - Reservado/Excluído/Disponível)
- Nome Usuário
*/

public class HistoricoLivro {
    public Livro codigo;
    public Livro nome;
    public Livro autor;
    public String status;
    public Usuario nomeUsuario;

    // Método construtor:
    public HistoricoLivro(Livro codigo,
                          Livro nome,
                          Livro autor,
                          String status,
                          Usuario nomeUsuario){
        this.codigo = codigo;
        this.nome = nome;
        this.autor = autor;
        this.status = status;
        this.nomeUsuario = nomeUsuario;
    }

}
