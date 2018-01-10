package br.ufop.ntifront.ntiFront.controller;

import br.ufop.ntifront.ntiFront.entity.Aluno;
import br.ufop.ntifront.ntiFront.repository.AlunoRepository;
import br.ufop.ntifront.ntiFront.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Aluno> getAll() {
        return alunoService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Aluno> add(@RequestBody @Valid Aluno aluno) {
        try{
            Aluno _aluno = alunoService.add(aluno);
            return ResponseEntity.ok(aluno);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(null);

        }
    }
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<Aluno> edit(@RequestBody @Valid Aluno aluno) {
        try{
            Aluno _aluno = alunoService.find(aluno.getId());
            if(aluno != null){
                alunoService.save(aluno);
            }
            return ResponseEntity.ok().body(aluno);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(null);

        }
    }

    @RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@PathVariable("id") Integer id){
        try{
            alunoService.delete(id);
            return ResponseEntity.ok().body(null);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

}
