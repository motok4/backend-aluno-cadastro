package br.ufop.ntifront.ntiFront.controller;

import br.ufop.ntifront.ntiFront.entity.Disciplina;
import br.ufop.ntifront.ntiFront.entity.Disciplina;
import br.ufop.ntifront.ntiFront.service.DisciplinaService;
import br.ufop.ntifront.ntiFront.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Disciplina> getAll() {
        return disciplinaService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Disciplina> add(@RequestBody @Valid Disciplina aluno) {
        try{
            Disciplina _aluno = disciplinaService.add(aluno);
            return ResponseEntity.ok(aluno);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(null);

        }
    }
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<Disciplina> edit(@RequestBody @Valid Disciplina aluno) {
        try{
            Disciplina _aluno = disciplinaService.find(aluno.getId());
            if(aluno != null){
                disciplinaService.save(aluno);
            }
            return ResponseEntity.ok().body(aluno);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(null);

        }
    }

    @RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@PathVariable("id") Integer id){
        try{
            disciplinaService.delete(id);
            return ResponseEntity.ok().body(null);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

}
