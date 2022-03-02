package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dtos.LoginCredentials;


@RestController
public class LoginController {

	@PostMapping("/login")
	public void login (@RequestBody LoginCredentials loginCredentials) {
		
	}
}
