package com.te.leraningmanagementsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition /* localhost:8090/swagger-ui/index.html */
public class LearningmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningmanagementsystemApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	return new ModelMapper();	
	}
}
