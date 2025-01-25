package com.backend.boletos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BackendBoletosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBoletosApplication.class, args);
	}

}
@Component
 class runner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		
	}
	
}