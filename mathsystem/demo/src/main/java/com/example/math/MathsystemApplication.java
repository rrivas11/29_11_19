package com.example.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-config.xml")
public class MathsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathsystemApplication.class, args);
	}

}
