package com.backend.boletos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.boletos.model.UsuarioModel;

@Repository 
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    

    @Query("SELECT u FROM UsuarioModel u WHERE u.username = :username")
    UsuarioModel findUserByUsername(@Param("username") String username);
}
