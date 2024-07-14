# Workshop MongoDB API

Esta API foi desenvolvida para um workshop de MongoDB e fornece operações CRUD para gerenciar usuários e posts. A API está implementada utilizando Java com Spring Boot e MongoDB.

## Índice

- [Descrição](#descrição)
- [Instalação](#instalação)
- [Uso](#uso)
- [Endpoints](#endpoints)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Descrição

Esta API permite realizar operações básicas de CRUD (Criar, Ler, Atualizar, Deletar) para usuários e posts. Também permite buscas personalizadas por título de post e buscas completas que consideram texto e intervalo de datas.

## Instalação

### Pré-requisitos

- Java 11 ou superior
- Maven
- MongoDB

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/workshop-mongodb-api.git
   cd workshop-mongodb-api

2.Configure o MongoDB no application.properties:

spring.data.mongodb.uri=mongodb://localhost:27017/seu-database

3.Compile e execute a aplicação:

mvn clean install
mvn spring-boot:run

Uso
A API estará disponível em http://localhost:8080.

Exemplo de uso com cURL
Criar um usuário
curl -X POST -H "Content-Type: application/json" -d '{"name": "John Doe", "email": "john@example.com"}' http://localhost:8080/users

Obter todos os usuários
curl -X GET http://localhost:8080/users

### Endpoints
### Usuários
GET /users: Retorna todos os usuários.

GET /users/{id}: Retorna um usuário pelo ID.

POST /users: Cria um novo usuário.

DELETE /users/{id}: Deleta um usuário pelo ID.

PUT /users/{id}: Atualiza um usuário pelo ID.

GET /users/{id}/posts: Retorna todos os posts de um usuário pelo ID.

### Posts
GET /posts/{id}: Retorna um post pelo ID.

GET /posts/titlesearch?text={text}: Busca posts pelo título.

GET /posts/fullsearch?text={text}&minDate={minDate}&maxDate={maxDate}: Busca completa de posts com parâmetros de texto e data.

### Estrutura do Projeto
domain: Contém as classes de domínio (entidades).

dto: Contém as classes Data Transfer Object (DTO).

repository: Contém as interfaces de repositório que estendem MongoRepository.

resources: Contém os controladores REST.

service: Contém as classes de serviço que implementam a lógica de negócios.

resources/util: Contém utilitários como decodificação de URL e conversão de datas.

### Contribuição
Fork o repositório

Crie uma branch para sua feature (git checkout -b feature/fooBar)

Commit suas alterações (git commit -am 'Add some fooBar')

Push para a branch (git push origin feature/fooBar)

Crie um novo Pull Request

### Licença
Distribuído sob a licença MIT. Veja LICENSE para mais informações.

Esse formato deve ser renderizado corretamente no GitHub, exibindo os blocos de código com formatação apropriada e os cabeçalhos organizados. Certifique-se de substituir os placeholders como URLs do repositório e outras informações específicas do seu projeto.



