package com.provaJava.provaPratica.controllers;

import com.provaJava.provaPratica.entities.Treino;
import com.provaJava.provaPratica.services.TreinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    private TreinoService treinoService;
    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<?> listarTreinos() {
    List<Treino> treinos = treinoService.listarTreinos();
            return ResponseEntity.ok(treinos);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarTreino(@PathVariable Long id) {
        Optional<Treino> treino =treinoService.buscarTreinoPorId(id);
        return ResponseEntity.ok(treino.get());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarTreino(@RequestBody Treino treino) {
        treinoService.adicionarTreino(treino);
        return ResponseEntity.ok(treino);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarTreino(@RequestBody Long id) {
        treinoService.atualizarTreino(id);
        return ResponseEntity.ok("Treino atualizado");
    }

    @DeleteMapping("excluir")
    public ResponseEntity<?> excluirTreino(@RequestBody Long id) {
        treinoService.removerTreino(id);
        return ResponseEntity.ok("Treino deletado");
    }
}
