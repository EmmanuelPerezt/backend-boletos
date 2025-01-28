package com.backend.boletos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/hola")
    public String index() {
        return "index";
    }
}
