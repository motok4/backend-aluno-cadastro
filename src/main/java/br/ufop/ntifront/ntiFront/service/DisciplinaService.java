package br.ufop.ntifront.ntiFront.service;

import br.ufop.ntifront.ntiFront.entity.Aluno;
import br.ufop.ntifront.ntiFront.entity.Disciplina;
import br.ufop.ntifront.ntiFront.repository.AlunoRepository;
import br.ufop.ntifront.ntiFront.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public Disciplina add(Disciplina disciplina){
        List<Aluno> alunos = new ArrayList<Aluno>();
        for(Integer i:disciplina.getStudents()){
            Aluno alunoBuscado =  alunoRepository.findOne(i);
            if( alunoBuscado !=null){
                alunos.add(alunoBuscado);
                System.out.println( alunoBuscado );
            }
        }
        disciplina.setAlunos(alunos);
        disciplinaRepository.save(disciplina);
        return disciplina;
    }

    public void delete(Integer id){
        disciplinaRepository.deleteAlunosDisciplinas(id);
        disciplinaRepository.delete(id);

    }

    public List<Disciplina> findAll(){
        return disciplinaRepository.findAll();
    }

    public Disciplina find(Integer id){
        return disciplinaRepository.findOne(id);
    }
    public void save(Disciplina disciplina){
        disciplinaRepository.save(disciplina);
    }
    public Disciplina findOne(Integer id){
        return disciplinaRepository.findOne(id);
    }

}
