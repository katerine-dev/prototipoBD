# Create Read Update e Delete


CRUD é acrônimo para Create (Criar), Read (Ler), Update (Atualizar) e Delete (Excluir). Essas são as quatro funções básicas de um sistema que trabalha com um banco de dados. Essas operações são usadas para manipular em um banco de dados, permitindo que os usuários criem, leiam, atualizem e excluam registros.

A3 - Criação de um sistema CRUD em Java.

O sistema deverá conter todas as operações CRUD
Pode ser usado:

- Interface gráficos
- Bancos de dados relacional
- O sistema deverá ser capaz de gerar relatórios (inclusive no próprio terminal) 


-[] Banco de Dados SQL com 3 tabelas:
    - [] Livros (contendo informações sobre 'codigoLivro'; 'nome'; 'autor'; 'categoria')
    - [] Usuário (contendo informações sobre 'nomeUsuario'; 'RA')
    - [] Historico/Emprestimo (contendo informações histórico de reserva/exclusão/disponível
        sobre 'codigoLivro'; 'nome'; 'autor'; 'status'; 'nomeUsuario')

- Para cada entidade uma classe.
- O sistema não terá interface gráfica, será programado para ter uma interface no terminal, utilizando a main. 
  - Funções
- Criar pesquisa por nome e categoria (resposta com informações dos livros) - pesquisar como mostrar a lista de livros 
- Criar pesquisa de histórico para a bibliotecária
- Update: Fará parte do CRUD da tabela livros 
- Delete: "excluir livro danificado"
- ID precisa ter livros duplicados.
- Método emprestar e devoler - todos o CRUD terá um método. 