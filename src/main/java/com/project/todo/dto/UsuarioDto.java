package com.project.todo.dto;

import com.project.todo.model.entities.Usuario;

public class UsuarioDto {
    private int id;
    private String nome;
    private String email;

    public UsuarioDto(){}

    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
