package com.backend.boletos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boletos.dtos.EventoDto;
import com.backend.boletos.service.EventoService;

@RestController
@RequestMapping("/api")
public class EventoController {



    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }
    
    @GetMapping("/eventos")
    public ResponseEntity<List<EventoDto>> listAllEventos() {
        List<EventoDto> eventos = eventoService.getAllEventos();
        return ResponseEntity.ok().body(eventos);
    }
}
