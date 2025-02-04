package com.backend.boletos.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.backend.boletos.dtos.BoletoDto;
import com.backend.boletos.model.BoletoModel;
import com.backend.boletos.model.EventoModel;
import com.backend.boletos.model.UsuarioModel;
import com.backend.boletos.repository.BoletoRepository;
import com.backend.boletos.repository.EventoRepository;
import com.backend.boletos.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class BoletoService {
    
    private final BoletoRepository boletoRepository;
    private final EventoRepository eventoRepository;
    private final UsuarioRepository usuarioRepository;

    public BoletoService(BoletoRepository boletoRepository, EventoRepository eventoRepository, UsuarioRepository usuarioRepository) {
        this.boletoRepository = boletoRepository;
        this.eventoRepository = eventoRepository;
        this.usuarioRepository = usuarioRepository;
    }



    @Transactional
    public void createBoleto(BoletoDto boleto) {

        EventoModel id_evento = eventoRepository.findById(boleto.id_evento()).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        UsuarioModel id_usuario = usuarioRepository.findById(boleto.id_usuario()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        var boletoparse = new BoletoModel(UUID.randomUUID(), boleto.precio(), id_evento, id_usuario);
    
        boletoRepository.save(boletoparse);

    }
    public void getBoleto(Long id) {
        boletoRepository.findById(id);
    }
    @Transactional
    public void updateBoleto(Long id, BoletoDto boleto) {

        BoletoModel boletoModel = boletoRepository.findById(id).get();
        boletoModel.setPrecio(boleto.precio());
        boletoModel.setEvento(eventoRepository.findById(boleto.id_evento()).get());
        boletoModel.setUsuario(usuarioRepository.findById(boleto.id_usuario()).get());
        boletoRepository.save(boletoModel);
    }   
    public void deleteBoleto(Long id) {
        boletoRepository.deleteById(id);
    }
}
