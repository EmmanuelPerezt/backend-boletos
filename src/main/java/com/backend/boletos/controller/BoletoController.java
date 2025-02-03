package com.backend.boletos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BoletoController {
    

    @GetMapping
    public String getBoletobyid(){
        //todo implementar esto
        return "boletos";
    }

    //implementar los demas metodos


}
