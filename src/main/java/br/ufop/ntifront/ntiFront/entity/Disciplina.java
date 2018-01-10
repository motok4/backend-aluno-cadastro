package br.ufop.ntifront.ntiFront.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Disciplina {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String code;

    @JsonIgnore
    @OneToMany(mappedBy = "disciplina",  cascade = CascadeType.ALL)
    private List<Aluno> alunos;


    public Disciplina() { super(); }

    public Disciplina(Integer id, String name, String code) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
