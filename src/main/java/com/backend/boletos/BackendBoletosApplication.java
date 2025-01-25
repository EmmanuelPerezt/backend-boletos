package com.backend.boletos;



import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.backend.boletos.dtos.EventoDto;
import com.backend.boletos.service.EventoService;

@SpringBootApplication
public class BackendBoletosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBoletosApplication.class, args);
	}

}
@Component
 class runner implements CommandLineRunner {

	private final EventoService eventoService;

	public runner(EventoService eventoService) {
		this.eventoService = eventoService;
	}


	@Override
	public void run(String... args) throws Exception {

		List<EventoDto> eventos = Arrays.asList(
			new EventoDto("concierto1", "concierto de rock", LocalDateTime.now(), "foro sol", 1000),
			new EventoDto("concierto2", "concierto de rock", LocalDateTime.now(), "foro sol", 1000),
			new EventoDto("concierto3", "concierto de rock", LocalDateTime.now(), "foro sol", 1000)
		);
		eventos.forEach(
			evento -> eventoService.createEvento(evento)
		);		
	}
}