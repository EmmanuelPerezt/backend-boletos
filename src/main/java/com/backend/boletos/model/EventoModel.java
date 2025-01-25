package com.backend.boletos.model;

import java.time.LocalDateTime;
import java.util.List;

import com.backend.boletos.dtos.EventoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "eventos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_evento;
    private String descripcion;
    private LocalDateTime fecha;
    private String lugar;
    private int capacidad;

    @OneToMany(mappedBy = "evento")
    private List<BoletoModel> boletos;


    public EventoModel(EventoDto eventoDto) {
        this.nombre_evento = eventoDto.nombre();
        this.descripcion = eventoDto.descripcion();
        this.fecha = eventoDto.fecha();
        this.lugar = eventoDto.lugar();
        this.capacidad = eventoDto.capacidad();
    }

}
