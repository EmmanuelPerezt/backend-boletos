package com.backend.boletos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.boletos.dtos.UsuarioDto;
import com.backend.boletos.model.UsuarioModel;
import com.backend.boletos.repository.UsuarioRepository;

@Service
public class UsuarioService {
    


    private final  UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder= passwordEncoder;
    }


    public void createUsuario(UsuarioDto usuarioDto){
        var usuario = new UsuarioModel(usuarioDto.username(), passwordEncoder.encode(usuarioDto.password()));
        usuarioRepository.save(usuario);
    }
    public List<String> getByID(long id){
        var usuario= usuarioRepository.findById(id).get();
        List<String> lista = new ArrayList<>();
        lista.add(usuario.getUsername());
        return lista;
    }
    public Boolean login(UsuarioDto usuarioDto){
       var user = usuarioRepository.findUserByUsername(usuarioDto.username());
      return passwordEncoder.matches(usuarioDto.password(), user.getPassword());
    }
}   
