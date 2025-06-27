package com.project.todo.controller;

import com.project.todo.dto.TarefaDto;
import com.project.todo.model.entities.Tarefa;
import com.project.todo.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    TarefaService tarefaService;

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> buscarPorId (@PathVariable Integer id){
        Optional<Tarefa> tarefaOpt = tarefaService.buscarPorId(id);
        if(tarefaOpt.isPresent()){
            TarefaDto tarefaDto = new TarefaDto(tarefaOpt.get());
            return ResponseEntity.ok(tarefaDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TarefaDto> criar(@RequestBody @Valid Tarefa tarefa){
        Tarefa criaTarefa = tarefaService.criar(tarefa);
        TarefaDto tarefaDto = new TarefaDto(criaTarefa);
        return ResponseEntity.ok(tarefaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TarefaDto> deletar(@PathVariable Integer id){
        Optional<Tarefa> removidotOpt = tarefaService.remover(id);
        if(removidotOpt.isPresent()){
            TarefaDto tarefaDto = new TarefaDto(removidotOpt.get());
            return ResponseEntity.ok().body(tarefaDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<TarefaDto>> listarTarefasDoUsuario(@PathVariable Integer idUsuario) {
        List<TarefaDto> tarefas = tarefaService.buscarTarefaUsuario(idUsuario)
                .stream()
                .map(TarefaDto::new)
                .toList();
        return ResponseEntity.ok(tarefas);
    }


}
