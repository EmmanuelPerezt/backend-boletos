package com.backend.boletos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.boletos.model.BoletoModel;

@Repository
public interface BoletoRepository extends JpaRepository<BoletoModel, Long> {
    
}
