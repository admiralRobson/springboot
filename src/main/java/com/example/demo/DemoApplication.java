package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
//	private static final org.slf4j.Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	
	
	
	public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
	}
	/*
	 * @Bean public RestTemplate restTemplate(RestTemplateBuilder builder) { return
	 * builder.build(); }
	 * 
	 * @Bean public CommandLineRunner runner(RestTemplate restTemplate) throws
	 * Exception { return args -> { Quote quote =
	 * restTemplate.getForObject("https://reqres.in/api/unknown/1", Quote.class);
	 * 
	 * log.info(quote.toString()); };
	 * 
	 * }
	 */



}