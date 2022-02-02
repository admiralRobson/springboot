package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloService;

@RestController
public class HelloController {

	private final HelloService helloService;
	
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}


	@GetMapping("/hello")
	public String hello()
	{
		return helloService.hello();
	}
}