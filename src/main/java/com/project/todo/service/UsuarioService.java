package com.project.todo.service;

import com.project.todo.model.entities.Usuario;
import com.project.todo.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
//    @Autowired
//    private Usuario usuario;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criar(Usuario usuario){
        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new RuntimeException("Email ja cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Integer id){
        return usuarioRepository.findById(id);
    }

    public Usuario atualizar(Integer id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setSenha(usuario.getSenha());
        return usuarioRepository.save(usuarioExistente);
    }

    public Optional<Usuario> remover(Integer id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        usuarioOpt.ifPresent(usuario -> usuarioRepository.deleteById(id));
        return usuarioOpt;
    }

}
