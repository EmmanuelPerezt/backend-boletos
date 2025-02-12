package com.backend.boletos.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boletos.dtos.BoletoDto;
import com.backend.boletos.dtos.BoletoResponseDto;
import com.backend.boletos.service.BoletoService;


@RestController
@RequestMapping("/api")
public class BoletoController {
    
    private final BoletoService boletoService;

    public BoletoController(BoletoService boletoService){

        this.boletoService=boletoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<BoletoResponseDto>> getBoletobyid(@PathVariable Long id){
        
        return ResponseEntity.ok().body(boletoService.finByUserId(id));
    }
    @PostMapping
    public ResponseEntity<BoletoResponseDto> createBoleto(@RequestBody BoletoDto boleto){

        return ResponseEntity.ok().body(boletoService.createBoleto(boleto));
    }
    @PostMapping("/{uuid}")
    public ResponseEntity<BoletoDto> updateBoleto(@PathVariable UUID uuid, @RequestBody BoletoDto boleto){
        return ResponseEntity.ok().body(boletoService.updateBoleto(uuid, boleto));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteBoleto(@PathVariable UUID uuid){

        boletoService.deleteBoleto(uuid);
        return ResponseEntity.ok().build();
    }
}
