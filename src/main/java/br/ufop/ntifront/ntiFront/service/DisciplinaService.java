package br.ufop.ntifront.ntiFront.service;

import br.ufop.ntifront.ntiFront.entity.Disciplina;
import br.ufop.ntifront.ntiFront.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina add(Disciplina aluno){
        disciplinaRepository.save(aluno);
        return aluno;
    }

    public void delete(Integer id){
        disciplinaRepository.delete(id);
    }

    public List<Disciplina> findAll(){
        return disciplinaRepository.findAll();
    }

    public Disciplina find(Integer id){
        return disciplinaRepository.findOne(id);
    }
    public void save(Disciplina aluno){
        disciplinaRepository.save(aluno);
    }

}
