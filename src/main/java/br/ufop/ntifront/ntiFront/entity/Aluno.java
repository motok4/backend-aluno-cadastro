package br.ufop.ntifront.ntiFront.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    private Integer cell;

    @Column
    @NotNull
    @NotEmpty
    private String course;

    @ManyToOne
    @JoinColumn(name="disciplina_id")
    private Disciplina disciplina;


    public Aluno() { super(); }

    public Aluno(Integer id, String name, String email, Integer cell, String course) {
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

    public Integer getCell() {
        return cell;
    }

    public void setCell(Integer cell) {
        this.cell = cell;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
