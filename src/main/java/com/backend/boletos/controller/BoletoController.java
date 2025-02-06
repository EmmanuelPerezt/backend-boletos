package com.backend.boletos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.boletos.service.BoletoService;

@RestController
@RequestMapping("/api")
public class BoletoController {
    
    private final BoletoService boletoService;

    public BoletoController(BoletoService boletoService){

        this.boletoService=boletoService;
    }

    @GetMapping
    public String getBoletobyid(@RequestParam Long id){
        
        boletoService.finByUserId(id);
        return "boletos";
    }

    //implementar los demas metodos


}
