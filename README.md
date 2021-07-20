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

### Aula 02.06 - Sobre findById
Qual a finalidade de utilizarmos o Optional retornado pelo método findById?

`R:` O comando pode retornar um elemento, se existir, por isso é usado Optional. O findById sempre devolve um Optional, que sabe se o elemento existe ou não. Assim, não precisamos lidar com null ou tratar uma exceção.

### Aula 02.07 - Desafio

### Aula 02.08 - Solução proposta

### Aula 02.09 - Para saber mais: Mais métodos
Caso tenha interesse de saber mais sobre outros repositórios que o framework disponibiliza, você pode acessar a [documentação do Spring Data](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/Repository.html).

### Aula 02.10 - Faça como eu fiz

### Aula 02.11 - O que aprendemos?
- como utilizar a ferramenta de repositório do framework;
- inserir um registro dinâmico na base de dados;
- atualizar registros salvos;
- deletar um registro por meio do seu ID;
- visualizar todos os registros salvos.

## Módulo 03 - Derived Queries, JPQL e Native Queries

### Aula 03.01 - Projeto da aula anterior

### Aula 03.02 - Derived Query

### Aula 03.03 - Para saber mais: Mais Derived Queries
Em vídeo, vimos como buscar funcionários pelo método findByNome dentro do repositório:
```java
@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);
}
```

As queries derivadas são simples, mas poderosas, e oferecem mais variações e recursos. Seguem alguns exemplos:

#### Usando Like
Para executar um like (e não um equals, como no exemplo), use:
```java
List<Funcionario> findByNomeLike(String nome);
```

O valor do parâmetro nome deve usar o pattern, por exemplo:
```java
String nome = "%maria%";
```

#### Starting e Ending
Você também pode buscar os funcionários pelo prefixo ou sufixo:
```java
List<Funcionario> findByNomeEndingWith(String nome)
```

Ou:
```java
List<Funcionario> findByNomeStartingWith(String nome)
```

#### Null e not Null
Igualmente podemos pesquisar elemento nulos ou não nulos:
```java
List<Funcionario> findByNomeIsNull()
```

Ou não nulos com:
```java
List<Funcionario> findByNomeIsNotNull()
```

#### Ordenação
Ainda vamos falar sobre ordenação e páginas, mas claro que a Derived Query pode dar suporte:
```java
List<Funcionario> findByNomeOrderByNomeAsc(String nome);
```

#### Métodos longos
E como dica, como definimos os critérios de pesquisa por meio do nome do método, precisamos ter cuidado para não criar nomes gigantes e prejudicar a legibilidade. Nesse caso devemos favorecer as consultas com JPQL apresentadas no próximo vídeo.

#### Documentação
Por fim [aqui está a documentação do Spring Data JPA ](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods), com mais exemplos.
