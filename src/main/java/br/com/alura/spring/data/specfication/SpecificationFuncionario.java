package br.com.alura.spring.data.specfication;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationFuncionario {
    public static Specification<Funcionario> nome(String nome) {
        return ((root, criteriaQuery, criteriaBuilder) ->
            criteriaBuilder.like(root.get("nome"), "%" + nome + "%"));
    }
}
