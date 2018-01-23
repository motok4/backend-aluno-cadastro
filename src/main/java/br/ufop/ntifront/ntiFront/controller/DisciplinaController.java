package br.ufop.ntifront.ntiFront.controller;

import br.ufop.ntifront.ntiFront.entity.Aluno;
import br.ufop.ntifront.ntiFront.entity.Disciplina;
import br.ufop.ntifront.ntiFront.entity.Disciplina;
import br.ufop.ntifront.ntiFront.service.DisciplinaService;
import br.ufop.ntifront.ntiFront.service.DisciplinaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "Lista todas as disciplinas cadastradas", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<Disciplina> getAll() {
        return disciplinaService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "Adiciona uma disciplina", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Disciplina> add(@RequestBody @Valid Disciplina aluno) {
        try{
            Disciplina _aluno = disciplinaService.add(aluno);
            return ResponseEntity.ok(aluno);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(null);

        }
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "Edita uma disciplina", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Disciplina> edit(@RequestBody @Valid Disciplina aluno) {

        try{
            Disciplina _aluno = disciplinaService.find(aluno.getId());
            if(aluno != null){
                disciplinaService.add(aluno);
            }
            return ResponseEntity.ok().body(aluno);
        }catch (Exception e) {
            System.out.println( e.getMessage());
            return ResponseEntity.badRequest().body(null);

        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta uma disciplina", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity remove(@PathVariable("id") Integer id){
        try{

            disciplinaService.delete(id);
            return ResponseEntity.ok().body(null);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca uma disciplina", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Disciplina getDisciplina(@PathVariable("id") Integer id) {
        return disciplinaService.findOne(id);
    }

    @RequestMapping(value = "/{id}/alunos", method = RequestMethod.GET)
    @ApiOperation(value = "Busca a lista de alunos de uma disciplina", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<Aluno> getAlunos(@PathVariable("id") Integer id) {
        return disciplinaService.findOne(id).getAlunos();
    }




}
