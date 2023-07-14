package com.example.demo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner dataLoader(EmpleadoRepository repo) {
		return (args -> {
			
			log.info("Agregando datos de Empleados");
			
			repo.save(new Empleado("Juan Larrayoz"));
			repo.save(new Empleado("Jose Perez"));
			repo.save(new Empleado("Sofia Pascal"));
			
			log.info("Buscando todos los empleados");
			repo.findAll().forEach(System.out::println);
			
			log.info("Buscando empleado por nombre");
			
			repo.findByNombre("Juan Larrayoz").stream().forEach(System.out::println);
			
		});
	}
}
