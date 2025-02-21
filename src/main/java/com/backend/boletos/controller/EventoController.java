package com.backend.boletos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping("/eventos/{id}")
    public ResponseEntity<EventoDto> getEvento(@PathVariable Long id) {
        EventoDto evento = eventoService.getEvento(id);
        return ResponseEntity.ok().body(evento);
    }
    @PostMapping("/eventos")
    public ResponseEntity<Map<String,String>> createEvento(@RequestBody EventoDto evento){
        eventoService.createEvento(evento);
        return ResponseEntity.ok().body(Map.of("message", "Evento creado", "nombre", evento.nombre()));
    }

    @PutMapping("/eventos/{id}")
    public ResponseEntity<Map<String,String>> updateEvento(@PathVariable Long id, @RequestBody EventoDto evento) {
        eventoService.updateEvento(id, evento);
        return ResponseEntity.ok().body(Map.of("Status:","actualizado","id",id.toString()));
    }

    @DeleteMapping("/eventos/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
        return ResponseEntity.ok().build();
    }
}
