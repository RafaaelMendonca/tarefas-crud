package com.project.todo.service;

import com.project.todo.model.entities.Tarefa;
import com.project.todo.model.entities.Usuario;
import com.project.todo.model.repositories.TarefaRepository;
import com.project.todo.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Tarefa criar(Tarefa tarefa){
        Integer idUsuario = tarefa.getUsuario().getId();

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário com ID " + idUsuario + " não encontrado."));

        tarefa.setUsuario(usuario);
        tarefa.setData(LocalDate.now());

        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> buscarTarefaUsuario(Integer idUsuario){
        return tarefaRepository.findByUsuarioId(idUsuario);
    }

    public Optional<Tarefa> buscarPorId(Integer id) {
        return tarefaRepository.findById(id);
    }

    public Optional<Tarefa> remover(Integer id){
        Optional<Tarefa> tarefaOpt = tarefaRepository.findById(id);
        tarefaOpt.ifPresent(tarefa -> tarefaRepository.deleteById(id));
        return tarefaOpt;
    }

    public Tarefa atualizar(Integer id, Tarefa novaTarefa){
        Tarefa tarefaExistente = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        Integer idUsuario = novaTarefa.getUsuario().getId();
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário com ID " + idUsuario + " não encontrado."));

        tarefaExistente.setNome(novaTarefa.getNome());
        tarefaExistente.setStatus(novaTarefa.getStatus());
        tarefaExistente.setUsuario(usuario);

        return tarefaRepository.save(tarefaExistente);
    }

}
