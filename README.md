# curso-alura-spring-data-jpa

## Módulo 01 - Primeiro repositório

### Aula 01.01 - Apresentação

### Aula 01.02 - Sobre o ambiente
- [Repositório do projeto completo no Github](https://github.com/forks-projects/1795-curso-spring-data)

### Aula 01.03 - Configuração de ambiente

### Aula 01.04 - Criando a aplicação
- `@SpringBootApplication`: utilizamos para que ao iniciar o Framework do Spring, ele percorra todas as anotações que temos dentro da nossa aplicação para executá-las.
- `SpringApplication.run(CursoAluraSpringDataJpaApplication.class, args);` : inicia o Framework do Spring.

### Aula 01.05 - Configurando o banco

### Aula 01.06 - Gerando o banco de dados

### Aula 01.07 - Sobre SpringAplication.run()
Dentro da nossa classe SpringDataAplication temos nosso método main, que no Java é utilizado para iniciar uma aplicação. Dentro desse método adicionamos uma linha relacionada ao Spring:
```java
SpringApplication.run(SpringDataApplication.class, args)
```
Qual a função dessa linha?

`R:` Ela faz com que o framework do Spring seja inicializado junto a nossa aplicação. Além disso, existem algumas anotações como a @SpringBootApplication que devemos usar.

### Aula 01.08 - Usando CrudRepository

### Aula 01.09 - Inserindo valores

### Aula 01.10 - Qual o benefício do CrudRepository?
Qual a principal vantagem que temos em utilizar a interface CrudRepository dentro do nosso projeto?

`R:` Realizar métodos CRUD sem a necessidade de criar os objetos do JPA. Sem a necessidade de criar nenhum objeto do JPA, conseguimos realizar métodos do CRUD.

### Aula 01.11 - Para saber mais: Injeção de Dependências
O Spring ficou famoso por causa do Injeção de dependências (ou Dependency Injection (DI)), mas não foi o primeiro framework nem é o único que oferece esse recurso.

Hoje em dia a DI é amplamente usada e outros frameworks bem comuns são [Guice da Google](https://github.com/google/guice) e o [CDI](https://jakarta.ee/specifications/cdi/2.0/cdi-spec-2.0.html) do Jakarta EE.

### Aula 01.12 - Faça como eu fiz

### Aula 01.13 - O que aprendemos?
- qual a stack necessária para nosso projeto;
- configurar nosso projeto Spring para conectar ao banco de dados;
- criar tabelas de forma automática e alterar o nome delas conforme a necessidade da aplicação;
- utilizar os repositórios do framework para trazer agilidade nas nossas operações de CRUD.

## Módulo 02 - Operações CRUD

### Aula 02.01 - Projeto da aula anterior

### Aula 02.02 - Salvando o registro

### Aula 02.03 - Atualizando o registro

### Aula 02.04 - Quais operações?
No framework do Spring Data, quais métodos são utilizados para quais operações?

`R:` Para inserir ou atualizar usamos o método save. O método save serve para entidades transient e detached.

### Aula 02.05 - Visualizar e deletar

