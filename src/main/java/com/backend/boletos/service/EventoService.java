package com.backend.boletos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.boletos.dtos.EventoDto;
import com.backend.boletos.model.EventoModel;
import com.backend.boletos.repository.EventoRepository;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;



    public void createEvento(EventoDto evento) {

        var eventoEntity = new EventoModel(evento);
        eventoRepository.save(eventoEntity);
    }
    public List<EventoDto> getAllEventos() {
        List<EventoModel> eventos = eventoRepository.findAll();
        List<EventoDto>eventoDto =eventos.stream().map(EventoDto::new).collect(Collectors.toList());
        return eventoDto;

    }
    public EventoDto getEvento(Long id) {
        var evento = eventoRepository.findById(1L).get();
        return new EventoDto(evento);
    }
    public void updateEvento(Long id ,EventoDto evento) {
        EventoModel eventoEntity = eventoRepository.findById(id).get();
        eventoEntity.setNombre_evento(evento.nombre());
        eventoEntity.setDescripcion(evento.descripcion());
        eventoEntity.setFecha(evento.fecha());
        eventoEntity.setLugar(evento.lugar());
        eventoEntity.setCapacidad(evento.capacidad());
        eventoRepository.save(eventoEntity);
    }
    public void deleteEvento(Long id) {
        try {
            eventoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Evento no encontrado");
        }
    }
}
