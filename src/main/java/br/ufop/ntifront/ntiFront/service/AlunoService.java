package br.ufop.ntifront.ntiFront.service;

import br.ufop.ntifront.ntiFront.entity.Aluno;
import br.ufop.ntifront.ntiFront.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno add(Aluno aluno){
        alunoRepository.save(aluno);
        return aluno;
    }

    public void delete(Integer id){
        alunoRepository.delete(id);
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public Aluno find(Integer id){
        return alunoRepository.findOne(id);
    }
    public void save(Aluno aluno){
        alunoRepository.save(aluno);
    }
    public Aluno findOne(Integer id){
        return alunoRepository.findOne(id);
    }

}
