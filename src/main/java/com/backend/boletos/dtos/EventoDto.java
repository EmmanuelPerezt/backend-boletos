package com.backend.boletos.dtos;

import java.time.LocalDateTime;

import com.backend.boletos.model.EventoModel;

public record EventoDto(String nombre, String descripcion, LocalDateTime fecha, String lugar, int capacidad) {
    public EventoDto(EventoModel eventoModel) {
        this(eventoModel.getNombre_evento(), eventoModel.getDescripcion(), eventoModel.getFecha(), eventoModel.getLugar(), eventoModel.getCapacidad());
    }
}
