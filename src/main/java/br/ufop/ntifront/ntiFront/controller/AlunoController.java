package br.ufop.ntifront.ntiFront.controller;

import br.ufop.ntifront.ntiFront.entity.Aluno;
import br.ufop.ntifront.ntiFront.repository.AlunoRepository;
import br.ufop.ntifront.ntiFront.service.AlunoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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


    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "Lista de todos alunos cadastrados", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<Aluno> getAll() {
        return alunoService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "Adiciona um usuário", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Aluno> add(@RequestBody @Valid Aluno aluno) {
        try{
            Aluno _aluno = alunoService.add(aluno);
            return ResponseEntity.ok(aluno);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(null);

        }
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "Edita um usuário", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
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

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta um usuário", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity remove(@PathVariable("id") Integer id){
        try{
            alunoService.delete(id);
            return ResponseEntity.ok().body(null);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca um usuário", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Aluno getAluno(@PathVariable("id") Integer id) {
        return alunoService.findOne(id);
    }

}


