package com.project.todo.model.repositories;

import com.project.todo.model.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    List<Tarefa> findByUsuarioId(Integer idUsuario);
}
