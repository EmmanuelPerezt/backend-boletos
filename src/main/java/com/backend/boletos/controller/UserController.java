package com.backend.boletos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boletos.dtos.UsuarioDto;
import com.backend.boletos.service.UsuarioService;

@RestController
@RequestMapping("/users")
public class UserController {

private final UsuarioService usuarioService;

public UserController(UsuarioService usuarioService){
    this.usuarioService = usuarioService;
}

    @GetMapping("/{id}")
    public ResponseEntity<List<String>> getUser(@PathVariable Long id){
       List<String> usuario =usuarioService.getByID(id);
        return ResponseEntity.ok().body(usuario);
    }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UsuarioDto usuarioDto){
        usuarioService.createUsuario(usuarioDto);

        return ResponseEntity.ok().body(usuarioDto.username());
    }
    @RequestMapping("/login")
    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestBody UsuarioDto usuarioDto){
        Map <String, String> response = new HashMap<>();
        response.put("message", "usuario correcto");
        return usuarioService.login(usuarioDto) 
        ? ResponseEntity.ok().body(response)
        : ResponseEntity.notFound().build();
    }
}
