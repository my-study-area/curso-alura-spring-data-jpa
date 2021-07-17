package br.com.alura.spring.data.orm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cpf;

    private Double salario;

    private LocalDate dataContratacao;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    @ManyToMany
    private List<UnidadeTrabalho> unidadesTrabalho;

    public Funcionario() {
        this.dataContratacao = LocalDate.now();
    }

    public Funcionario(String nome, String cpf, Double salario, Cargo cargo) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Funcionario(Integer id, String nome, String cpf, Double salario, Cargo cargo) {
        this();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setUnidadeTrabalhos(List<UnidadeTrabalho> unidadesTrabalho) {
        this.unidadesTrabalho = unidadesTrabalho;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargo=" + cargo.getDescricao() +
                '}';
    }
}
