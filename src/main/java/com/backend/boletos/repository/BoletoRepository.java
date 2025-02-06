package com.backend.boletos.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.boletos.model.BoletoModel;

@Repository
public interface BoletoRepository extends JpaRepository<BoletoModel, UUID> {
    

    @Query("SELECT b FROM BoletoModel b WHERE b.usuario.id = :usuarioId")
    List<BoletoModel> findByUsuarioID(@Param("usuarioId") Long usuarioId);
}