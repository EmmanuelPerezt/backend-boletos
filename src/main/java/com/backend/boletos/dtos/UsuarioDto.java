package com.backend.boletos.dtos;

import com.backend.boletos.model.UsuarioModel;

public record UsuarioDto(String username, String password) {
    public UsuarioDto(UsuarioModel usuarioModel){
        this(usuarioModel.getUsername(),"nonPassword");
    }
}
