package br.ufop.ntifront.ntiFront.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @NotEmpty
    private String name;

    @Column
    @NotNull
    @Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)(\\@)([a-zA-Z0-9\\-\\.]+)(\\.)([a-zA-Z]{2,4})$")
    private String email;

    @Column
    @NotNull
    private Long cell;

    @Column
    @NotNull
    @NotEmpty
    private String course;

    @Column
    @NotNull
    @NotEmpty
    private String state;

    @Column
    @NotNull
    @NotEmpty
    private String city;





    @ManyToMany(mappedBy = "alunos")
    private List<Disciplina> disciplinas;


    public Aluno() { super(); }

    public Aluno(Integer id, String name, String email, Long cell, String course) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.cell = cell;
        this.course = course;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCell() {
        return cell;
    }

    public void setCell(Long cell) {
        this.cell = cell;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Disciplina> getDisciplina() {
        return disciplinas;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplinas = disciplina;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
