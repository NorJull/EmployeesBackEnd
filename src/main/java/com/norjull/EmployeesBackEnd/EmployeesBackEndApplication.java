package com.norjull.EmployeesBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.Module;

import io.vavr.jackson.datatype.VavrModule;

@SpringBootApplication
public class EmployeesBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesBackEndApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}
	
	@Bean
    public Module vavrModule() {
        return new VavrModule();
    }
}
