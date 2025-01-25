package com.backend.boletos.service;

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
    public void getEvento() {
        // TODO Auto-generated method stub
    }
    public void updateEvento() {
        // TODO Auto-generated method stub
    }
    public void deleteEvento() {
        // TODO Auto-generated method stub
    }
}
