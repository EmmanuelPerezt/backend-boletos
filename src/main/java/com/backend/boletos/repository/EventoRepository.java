package com.backend.boletos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.boletos.model.EventoModel;

@Repository
public interface EventoRepository extends JpaRepository<EventoModel, Long> {
}
