package com.backend.boletos;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.backend.boletos.dtos.BoletoDto;
import com.backend.boletos.service.BoletoService;




@SpringBootApplication
public class BackendBoletosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBoletosApplication.class, args);
	}
}
@Component
 class runner implements CommandLineRunner {

	private final BoletoService boletoService;

	public runner(BoletoService boletoService) {
		this.boletoService = boletoService;
	}

	@Override
	public void run(String... args) throws Exception {
		List<BoletoDto> boletos = Arrays.asList(new BoletoDto(300,1L,1L),
												new BoletoDto(500,1L,1L),
												new BoletoDto(800,1L,1L)
		);
		boletos.forEach(
			b->boletoService.createBoleto(b)
		);
	}
}