package com.provaJava.provaPratica.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany
    private List<Exercicio> exercicios;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
