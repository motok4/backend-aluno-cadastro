package br.ufop.ntifront.ntiFront.repository;

import br.ufop.ntifront.ntiFront.entity.Disciplina;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Integer>{
    List<Disciplina> findAll();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="DELETE FROM disciplinas_alunos WHERE disciplina_id=?1") // TODO transformar em Before, ou usar query do Spring
    void deleteAlunosDisciplinas(Integer id);

}
