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
