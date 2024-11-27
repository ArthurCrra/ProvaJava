package com.provaJava.provaPratica.controllers;

import com.provaJava.provaPratica.entities.Exercicio;
import com.provaJava.provaPratica.services.ExercicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<?> buscarExercicio(@RequestParam Long id) {
        List<Exercicio> exercicios = exercicioService.listarExercicio();
        return ResponseEntity.ok(exercicios);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarExercicioId(@PathVariable Long id) {
        Optional<Exercicio> exercicio = Optional.ofNullable(exercicioService.buscarExercicioPorId(id));
        return ResponseEntity.ok(exercicio.get());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarExercicio(@RequestBody Exercicio exercicio) {
        exercicioService.salvarExercicio(exercicio);
        return ResponseEntity.ok(exercicio);
    }

    @DeleteMapping("excluir")
    public ResponseEntity<?> excluirExercicio(@RequestBody Long id) {
        exercicioService.excluirExercicio(id);
        return ResponseEntity.ok("Exercicio deletado");
    }
}
