package com.provaJava.provaPratica.services;

import com.provaJava.provaPratica.entities.Exercicio;
import com.provaJava.provaPratica.entities.Treino;
import com.provaJava.provaPratica.repository.ExercicioRepository;
import com.provaJava.provaPratica.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {
    private final ExercicioRepository exercicioRepository;
    private TreinoRepository treinoRepository;


    public TreinoService(TreinoRepository treinoRepository, ExercicioRepository exercicioRepository) {
        this.treinoRepository = treinoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    public List<Treino> listarTreinos() {
        return treinoRepository.findAll();
    }

    public Optional<Treino> buscarTreinoPorId(Long id) {
    return treinoRepository.findById(id);
    }


    public Treino adicionarTreino(Treino treino) {
        List<Exercicio> exercicios = treino.getExercicios().stream()
                .map(id -> exercicioRepository.findById(id.getId())
                        .orElseThrow(() -> new RuntimeException("Exercicio não encontrado: ID " + id)))
                .toList();

        treino.setExercicios(exercicios);
        treino.setNome(treino.getNome());
        treino.setStatus(treino.getStatus());
        return treinoRepository.save(treino);
}

    public Treino atualizarTreino(Long id){
        Optional<Treino> treinoOptional = treinoRepository.findById(id);

            Treino treino = treinoOptional.get();
            treino.setNome(treino.getNome());
            treino.setStatus(treino.getStatus());
            return treinoRepository.save(treino);
    }

    public void removerTreino(Long id) {
    treinoRepository.deleteById(id);
    }
}
