package br.ufop.ntifront.ntiFront.repository;

import br.ufop.ntifront.ntiFront.entity.Disciplina;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Integer>{
    List<Disciplina> findAll();
}
