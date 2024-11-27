package com.provaJava.provaPratica.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer numeroSeries;
    private Integer repeticao;
    private Double descanso;

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

    public Integer getNumeroSeries() {
        return numeroSeries;
    }

    public void setNumeroSeries(Integer numeroSeries) {
        this.numeroSeries = numeroSeries;
    }

    public Integer getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Integer repeticao) {
        this.repeticao = repeticao;
    }

    public Double getDescanso() {
        return descanso;
    }

    public void setDescanso(Double descanso) {
        this.descanso = descanso;
    }
}



