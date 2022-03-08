package com.massMutual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class massMutualApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(massMutualApplication.class, args);

		

	}
}
