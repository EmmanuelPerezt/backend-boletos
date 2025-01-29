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
    public void getEvento() {
    
    }
    public void updateEvento() {
        // TODO Auto-generated method stub
    }
    public void deleteEvento() {
        // TODO Auto-generated method stub
    }
}
