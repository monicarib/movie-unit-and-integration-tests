# movie-unit-and-integration-tests
The purpose of this project is to teach unit and integration tests.

### Contexto da Aplicação:

Uma empresa precisa de um serviço que recebe o nome do filme e é retornado para ele as seguintes informações:
- Nome do Filme (title).
- Data de Lançamento (released).
- Tempo de Filme (runtime).
- Gênero (genre).
- Diretor (director).
- Resumo (plot).
- Classificação no iMDb (imdbRating).
- É um filme recomendável baseado na classificação? (isRecommended)

##### Critérios de Aceitação:

- O filme é recomendável se a nota do iMDb for maior ou igual a 7,1
- API REST.
- Spring Boot.
- Testes Unitários.
- Testes de Integração na camada do controlador.

##### Documentação da Integração:

**URL**:  http://www.omdbapi.com/

**apiKey**: http://www.omdbapi.com/apikey.aspx

##### Desafios:

1. Implementação do controller, response e request.

2. Definição do service, das classes de domínio e implementação da assinatura da função que será chamada pelo controller.

3. Implementação da integração do iMDb que será chamada pelo service, request e response da integração.

4. Implemenação dos testes unitários da camada de service.

5. Implemenação dos testes de integração na camada do controller.


##### Descrição Branches e Conceitos
**master**: apenas estrutura inicial do projeto.

**startup-mentoria**: estrutura inicial do projeto + *integração com a API* do iMDb feita com *Feign* + *testes unitários* na integração + utilização de stubs.