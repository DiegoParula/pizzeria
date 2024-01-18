package com.parula.pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//le decimos que utilizaremos repositorios de Spring
@EnableJpaRepositories
@EnableJpaAuditing
public class ProyectoPizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPizzeriaApplication.class, args);
	}

}
