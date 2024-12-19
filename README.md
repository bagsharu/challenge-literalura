# Literalura

Literalura é uma aplicação desenvolvida em **Spring Boot** com integração ao banco de dados **PostgreSQL**, que permite buscar e gerenciar dados de livros e autores utilizando a API pública [Gutendex](https://gutendex.com/). A interação com o usuário ocorre através de um menu no terminal, permitindo diversas operações relacionadas a livros e autores.

## Funcionalidades

A aplicação oferece as seguintes opções de interação no menu do prompt de comando:

```less
                
                Escolha uma opção:
                1 - Buscar um livro no Gutendex.
                2 - Listar Livros no banco de daods.
                3 - Listar Autores no banco de dados.
                4 - Procurar Autor por Ano.
                5 - Procurar Livro por Idioma.
                
                0 - Sair
```


## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Framework para simplificar o desenvolvimento de aplicações web.
  - **Spring Data JPA**: Para integração com o banco de dados.
- **PostgreSQL**: Banco de dados relacional utilizado para persistência.
- **Maven**: Gerenciamento de dependências e build.
- **Gutendex API**: Fonte de dados de livros e autores.

## Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- **Java 17** ou superior.
- **Maven**.
- **PostgreSQL**.
- Acesso à API Gutendex.

### Configuração do Banco de Dados

Certifique-se de criar um banco de dados PostgreSQL e configurar as credenciais no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}/literalura
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
spring.jpa.hibernate.ddl-auto=update
```
É necessário configurar as variáveis locais em seu sistema operacional:

- DB_HOST : Seu host do PostgreSQL
- DB_USER : Seu usuário no banco de dados
- DB_PASS : Sua senha de acesso ao banco de dados

### Como rodar

1. Clone este repositório:

```bash
git git@github.com:bagsharu/challenge-literalura.git
cd challenge-literalura
```
2. Compile o projeto:

```bash
mvn clean install
```

3. Execute a aplicação:

```bash
mvn spring-boot:run
```

4. Navegue pelo menu no terminal e explore as funcionalidades!

### Estrutura do Projeto

- **Model**: Representa as entidades (livros e autores).

- **Service**: Contém a lógica por trás da aplicação.

- **Repository**: Interface para interagir com o banco de dados.

- **Principal**: Responsável pela interação com o usuário.

### Melhorias futuras

- Adicionar suporte para mais opções de filtragem e busca.


### Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests com sugestões de melhorias.


<div>
    <p>
        <img src="badge_literalura.png" height="300" tittle="site"> 
    </p>
</div>
