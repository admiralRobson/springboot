package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.classic.Logger;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@RestController
public class DemoApplication {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	
	
	
	public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner runner(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject("https://reqres.in/api/unknown/1", Quote.class);
			
			log.info(quote.toString());
		}; 
		
	}




}