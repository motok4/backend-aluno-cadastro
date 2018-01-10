package br.ufop.ntifront.ntiFront.repository;

import br.ufop.ntifront.ntiFront.entity.Aluno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

    List<Aluno> findAll();
}
