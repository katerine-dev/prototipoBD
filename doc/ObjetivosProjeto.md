# Create Read Update e Delete


CRUD é acrônimo para Create (Criar), Read (Ler), Update (Atualizar) e Delete (Excluir). Essas são as quatro funções básicas de um sistema que trabalha com um banco de dados.
Essas operações são usadas para manipular em um banco de dados, permitindo que os usuários criem, leiam, atualizem e excluam registros.

A3 - Criação de um sistema CRUD em Java.

O sistema deverá conter todas as operações CRUD
Pode ser usado:

- Interface gráficos
- Bancos de dados relacional
- O sistema deverá ser capaz de gerar relatórios (inclusive no próprio terminal) 


### Banco de Dados SQL com 4 tabelas: (Relacional):


- Livros (contendo informações sobre 'codigoLivro'; 'nome'; 'autor'; 'categoria')
- Usuário (contendo informações sobre 'nomeUsuario'; 'RA')
- Historico/Emprestimo (contendo informações histórico de reserva/exclusão/disponível
        sobre 'codigoLivro'; 'nome'; 'autor'; 'status'; 'nomeUsuario')
- Categorias (contendo informação das categorias disponíveis)
- Usuário (classe pai, contendo informações de nome e email das partes) - Herança
- Leitor (classe filha, contendo informações da classe pai e um atributo excluivo "RA")
- Bibliotecaria (classe filha, contendo informações da classe pai e um atributo excluivo "CPF")

### Lógica 

- Para cada entidade uma classe.
- Uma classe para a conexão do BD Mysql (ok)
- O sistema não terá interface gráfica, será programado para ter uma interface no terminal, utilizando a main. 
  - Funções (ok)
- Criar pesquisa por nome e categoria (resposta com informações dos livros) - pesquisar como mostrar a lista de livros (ok)
- Update: Fará parte do CRUD da tabela livros (ok)
- Delete: "excluir livro danificado" (ok)
- ID precisa ter livros duplicados.
- Método emprestar e devoler - todos o CRUD terá um método. (ok)
- Criar uma conexão com MySQL (ok)
- Imprimir no console as informações de uma tabela (ok)
- Criar um script só para os testes de interação
- Escolhi fazer três pacotes diferentes: um contendo as classes com interações de database, outro com 
classes conceituais (getter, setter) e outro com os métodos de visualização.  (ok)
  - assim conseguimos vincular a classe responsável pela conexão as outras.
- Entendendo as exceções: 

    As exceções ocorrem quando algo imprevisto acontece, elas podem ser provenientes de erros de lógica ou acesso a recursos 
que talvez não estejam disponíveis.
Alguns possíveis motivos externos para ocorrer uma exceção são:
Tentar fazer consulta a um banco de dados que não está disponível.
Tentar conectar em servidor inexistente.
Para tratar as exceções em Java são utilizados os comandos try e catch ou throws exception