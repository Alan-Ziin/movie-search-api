# Procurador de filmes

Um projeto no qual utilizo a OMDB API para realizar buscas de filmes especificos, seja por titulo, id ou por ano.

## Tecnologias

- Java, Spring Boot, Jackson, JUnit, MockMvc, Maven, HttpClient

## Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/filmes/buscar/{title}` | Busca filmes por palavra-chave |
| GET | `/filmes/detalhe/{imdbID}` | Busca detalhes de um filme por ID (inclui rating) |
| GET | `/filmes/buscarPorAno?title=` | Busca filmes ordenados por ano, com rating |

## Como rodar localmente

1. Clone o repositório
2. Crie o arquivo `src/main/resources/application.properties`
3. Adicione sua chave da API do OMDb no arquivo: (link para pegar a KEY --> [omdbapi.com](https://www.omdbapi.com/apikey.aspx)):
```
omdb.api.key=SUA_CHAVE_AQUI
```
4. Rode a aplicação via IntelliJ ou sua IDE de preferência e acesse `http://localhost:8080`

## Aprendizados e aprimoramentos

- Utilizando o Spring Boot: Controllers, Services e injeção de dependência.
- Utilizando e diferenciando `@PathVariable` (identifica o recurso) e `@RequestParam` (filtra/refina uma busca)
- Tratamento de erros de API com `@ExceptionHandler` + `ResponseEntity`.
- Testes de integração com `MockMvc`, simulando requisições HTTP reais sem precisar de navegador/Postman
- Configuração externa de credenciais via `application.properties` e `@Value`.