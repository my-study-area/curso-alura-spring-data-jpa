package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends CrudRepository<UnidadeTrabalho, Integer> {
}
