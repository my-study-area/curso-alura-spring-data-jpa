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

### Aula 03.04 - Usando JPQL
Java Persistense Query Language (JPQL) é uma linguagem de consulta semelhante com a SQL e é definida na especificação da JPA. No SQL utilizanos as tabelas e colunas e na JPQL utilizamos as classes e objetos.

Utilizamos JPQL em casos em que as consultas utilizando Query Methods se torna muito extensa, como por exemplo:

```java
List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContrataca(
  String nome, Double salario, LocalDate data);
```

Para utilizarmos `JPQL` utilizamos a anotação `@Query` mais a sintaxe da consulta, como por exemplo:
```java
@Query("SELECT f FROM Funcionario f " +
        "WHERE f.nome = :nome " +
        "AND f.salario >= :salario " +
        "AND f.dataContratacao = :data")
List<Funcionario> findByNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);
```

### Aula 03.05 - Para saber mais: Queries entre relacionamentos
No Spring Data conseguimos realizar consultas com `Derived Query Methods` e `JPQL` através da anotação `@Query`.

Exemplo de consulta usando `Query Methods`:
```java
List<Funcionario> findByCargoDescricao(String descricao);
```

Exemplo de utilização de JPQL com a anotação `@Query`:
```java
@Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
List<Funcionario> findByCargoPelaDescricao(String descricao);
```

Para realizarmos consultas, utilizando os relacionamentos de uma classe com nome uma propriedade de nome composto, como por exemplo através do atributo `unidadesTrabalho` da classe `Funcionario`, devemos seguir o seguinte exemplo:
```java
List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
```

Observe que no exemplo acima não estamos seguindo a convenção do Java, sendo mais interessante a utilização da JPQL com a anotação `@Query`:
```java
@Query("SELECT f FROM Funcionario f JOIN f.unidadeTrabalhos u WHERE u.descricao = :descricao")
List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
```

### Aula 03.06 - Completando a aplicação
Para converter uma data de `String` para `LocalDate`:
```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String data = "29/08/2021";
LocalDate dataLocal = LocalDate.parse(data, formatter);
System.out.println(dataLocal);
```

### Aula 03.07 - Native Query
`Native Query` ou `Query Nativa` é a consulta padrão do SQL, ou seja, ela utiliza o nome das tabelas e colunas do banco de dados para realizar as cosultas. No Spring Data utilizamos a anotação `@Query` com dois parâmetros: `value` que é a consulta SQL e `nativeQuery` com valor true. Observe um exemplo aplicado num repository de uma aplicação utilizando Spring Data:
```java
@Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
List<Funcionario> findDataContratacaoMaior(LocalDate data);
```

### Aula 03.08 - Qual tipo de query usar?
Qual a diferença entre Derived Query, JPQL e Native Query?
- `R:` **Derived Queries** - queries criadas através de comandos Java.
**JPQL** - queries criadas através de uma estrutura SQL, porém com os nomes das entidades Java. **Native Query** - queries padrões SQL que conseguimos executar no nosso Client SQL.

### Aula 03.09 - Faça como eu fiz

### Aula 03.10 - O que aprendemos?
- como criar consultas atrás de comando java;
- utilizar JPQL com a anotação `@Query`;
- parâmetro da anotação `@Query` para executar queries nativas.

### Aula 04.01 - Projeto da aula anterior

### Aula 04.02 - Paginação
Para criarmos paginação no Spring Data devemos extender o nosso repository para `PagingAndSortingRepository`:
```java
@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {
}
```

E adicionarmos uma `Pageable`, como parâmetro, em nosso método de consulta:
```java
PageRequest pageable = PageRequest.of(page, 5, Sort.unsorted());
Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
```

### Aula 04.03 - Para saber mais: Paginação e Derived Query
Nas aulas anteriores vimos como buscar funcionários pelo nome usando o método **findByNome**:

```java
@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository <Funcionario, Integer> {

    List<Funcionario> findByNome(String nome);

    //outros métodos omitidos
}
```

Será que a paginação também funciona com esse tipo de método? Claro que sim, basta passar o `Pageable` como parâmetro. Veja o exemplo:

```java
@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository <Funcionario, Integer> {

    List<Funcionario> findByNome(String nome);

    //novo método com paginação
    List<Funcionario> findByNome(String nome, Pageable pageable);

    //outros métodos omitidos
}
```
A criação do objeto Pageable fica como foi explicado no vídeo usando o **PageRequest**. Lembrando também que a interface **FuncionarioRepository** deve estender o `PagingAndSortingRepository`.

  ### Aula 04.04 - Tipos de repositórios
  - [Repository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/Repository.html): é a interface mãe de todas as interfaces.
  - [CrudRepository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html): é uma interface filha de `Repository` e é uma interface genérica para CRUD.
  - [PagingAndSortingRepository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html): é a interface filha de `CrudRepository` e adiciona a paginação e ordenação.
  - [JpaRepository](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html):  é uma interface filha de `PagingAndSortingRepository` e trabalha muito bem com arquivos em lotes.

  ### Aula 04.05 - Ordenação
  Para ordenarmos a consulta devemos alterar o construtor de `PageRequest.of(page, 5, Sort.unsorted());`, alterando o parâmetro de ordenação de `Sort.unsorted()` para `Sort.by(Sort.Direction.ASC, "nome")`. Onde `Sort.Direction` pode ser receber o valor crescente ou decrescente, mais o nome da propriedade da classe que será ordenada. Exemplo:
  ```java
  // PageRequest.of(page, 5, Sort.unsorted());
  PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "nome"));
  ```

  ### Aula 04.06 - Como paginar?
  Quando utilizamos o repositório `PagingAndSortingRepository`, adicionamos à nossa aplicação todo o poder da paginação. Porém, para utilizarmos de fato esse poder, devemos passar um atributo no método findAll.

  Qual o atributo e por que o usamos?

  `R:` `Pageable` - enviamos esse objeto pois nele encapsulamos a página, a quantidade de itens por página e qual o tipo de ordenação. Enviamos esse objeto como parâmetro para informarmos ao nosso repository as informações que queremos receber na nossa paginação.
