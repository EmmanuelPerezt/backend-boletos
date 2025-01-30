package com.backend.boletos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.boletos.dtos.UsuarioDto;
import com.backend.boletos.model.UsuarioModel;
import com.backend.boletos.repository.UsuarioRepository;

@Service
public class UsuarioService {
    


    private final  UsuarioRepository usuarioRepository;
    

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    public void createUsuario(UsuarioDto usuarioDto){
        //se debe encriptar la contraseña
        var usuario = new UsuarioModel(usuarioDto.username(), usuarioDto.password());
        usuarioRepository.save(usuario);
    }
    public List<String> getByID(long id){
        var usuario= usuarioRepository.findById(id).get();
        List<String> lista = new ArrayList<>();
        lista.add(usuario.getUsername());
        return lista;
    }
}   
