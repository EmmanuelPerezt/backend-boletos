package com.backend.boletos.dtos;

import java.util.UUID;

import com.backend.boletos.model.BoletoModel;

public record BoletoResponseDto(UUID uuid, int precio, Boolean valido,EventoDto eventoDto, UsuarioDto usuarioDto) {
    public BoletoResponseDto(BoletoModel boleto){
        this(
            boleto.getId_boleto(),
            boleto.getPrecio(),
            boleto.getValido(),
            boleto.getEvento() != null ? new EventoDto(boleto.getEvento()) : null,
            boleto.getUsuario() != null ? new UsuarioDto(boleto.getUsuario()) : null
        );
    }
}
