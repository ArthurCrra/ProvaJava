package com.provaJava.provaPratica.services;

import com.provaJava.provaPratica.entities.Exercicio;
import com.provaJava.provaPratica.repository.ExercicioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {
    private ExercicioRepository exercicioRepository;


    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    @Transactional
    public Exercicio salvarExercicio(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
}

    public List<Exercicio> listarExercicio() {
        return exercicioRepository.findAll();
    }

    @Transactional
    public Exercicio buscarExercicioPorId(Long id) {
        return exercicioRepository.findById(id).orElse(null);
    }

    @Transactional
    public void excluirExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }
}
