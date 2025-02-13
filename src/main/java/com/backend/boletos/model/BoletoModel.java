package com.backend.boletos.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "boletos")
public class BoletoModel {


    public BoletoModel(UUID randomUUID, int precio, EventoModel id_evento,
            UsuarioModel id_usuario) {
        this.id_boleto = randomUUID;
        this.precio = precio;
        this.evento = id_evento;
        this.usuario = id_usuario;

    }

    @Id
    private UUID id_boleto;
    private int precio;
    @Column(columnDefinition = "boolean default false")
    private Boolean valido = true;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private EventoModel evento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioModel usuario;
}
