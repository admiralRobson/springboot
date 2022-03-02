package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.model.dtos.LoginCredentials;

public class LoginController {

	@PostMapping("/login")
	public void login (@RequestBody LoginCredentials loginCredentials) {
		
	}
}
