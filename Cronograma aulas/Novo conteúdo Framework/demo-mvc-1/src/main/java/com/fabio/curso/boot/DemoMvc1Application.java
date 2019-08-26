package com.fabio.curso.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class DemoMvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoMvc1Application.class, args);
	}

}
