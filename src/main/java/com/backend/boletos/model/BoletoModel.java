package com.backend.boletos.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class BoletoModel {
    @Id
    private UUID id;
    private String nombre;
    private Boolean valido;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventoModel evento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;


}
