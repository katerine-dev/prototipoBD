package prototipodb.model;
/*
Atributos:
- Codigo Livro
- Status (String - somente 3 possíveis - Reservado/Excluído/Disponível)
- RA leitor
*/

public class Emprestimo {
    public int codigoLivro;
    public String statusLivro;
    public String raLeitor;

    // Método construtor:
    public Emprestimo(int codigo, String status, String RA){
        this.codigoLivro = codigo;
        this.statusLivro = status;
        this.raLeitor = RA;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(int codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public String getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(String statusLivro) {
        this.statusLivro = statusLivro;
    }

    public String getRaLeitor() {
        return raLeitor;
    }

    public void setRaLeitor(String raLeitor) {
        this.raLeitor = raLeitor;
    }

    
    
}
