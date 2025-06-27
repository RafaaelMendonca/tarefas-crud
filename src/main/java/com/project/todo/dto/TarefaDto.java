package com.project.todo.dto;

import com.project.todo.model.entities.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class TarefaDto {

    private Integer id;
    private String nome;
    private LocalDate data;
    private Integer id_usuario;

    public TarefaDto(Tarefa tarefa){
        this.id = tarefa.getId();
        this.nome = tarefa.getNome();
        this.data = tarefa.getData();
        this.id_usuario = tarefa.getUsuario().getId();
    }
}
