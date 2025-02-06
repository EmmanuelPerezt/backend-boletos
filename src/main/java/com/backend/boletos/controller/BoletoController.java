package com.backend.boletos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boletos.dtos.BoletoResponseDto;
import com.backend.boletos.service.BoletoService;

@RestController
@RequestMapping("/api")
public class BoletoController {
    
    private final BoletoService boletoService;

    public BoletoController(BoletoService boletoService){

        this.boletoService=boletoService;
    }

    @GetMapping
    public ResponseEntity<List<BoletoResponseDto>> getBoletobyid(@RequestParam Long id){
        
        return ResponseEntity.ok().body(boletoService.finByUserId(id));
    }

    //implementar los demas metodos


}
