package com.project.todo.controller;

import com.project.todo.dto.UsuarioDto;
import com.project.todo.model.entities.Usuario;
import com.project.todo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> criar(@RequestBody @Valid Usuario usuario){
       Usuario criaUsuario = usuarioService.criar(usuario);
       UsuarioDto usuarioDto = new UsuarioDto(criaUsuario);
       return ResponseEntity.ok().body(usuarioDto);
    }

    @GetMapping
    public ResponseEntity<UsuarioDto> buscar(@RequestParam Integer id){
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(id);
        if(usuarioOpt.isPresent()){
            UsuarioDto usuarioDto = new UsuarioDto(usuarioOpt.get());
            return ResponseEntity.ok(usuarioDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDto> atualizar(
            @PathVariable Integer id,
            @RequestBody @Valid Usuario novoDadoUsuario
    ){
        Usuario atualizaUsuario = usuarioService.atualizar(id, novoDadoUsuario);
        UsuarioDto usuarioDto = new UsuarioDto(atualizaUsuario);
        return ResponseEntity.ok().body(usuarioDto);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDto> deletar(@PathVariable Integer id) {
        Optional<Usuario> removidoOpt = usuarioService.remover(id);
        if (removidoOpt.isPresent()) {
            UsuarioDto usuarioDto = new UsuarioDto(removidoOpt.get());
            return ResponseEntity.ok().body(usuarioDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
