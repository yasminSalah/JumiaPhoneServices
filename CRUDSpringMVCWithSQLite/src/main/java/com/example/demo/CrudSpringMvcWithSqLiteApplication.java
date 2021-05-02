package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableAutoConfiguration
@SpringBootApplication
public class CrudSpringMvcWithSqLiteApplication extends SpringBootServletInitializer{

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CrudSpringMvcWithSqLiteApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CrudSpringMvcWithSqLiteApplication.class, args);
	}

}
