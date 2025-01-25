package com.backend.boletos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.boletos.model.UsuarioModel;

@Repository 
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    
}
