package com.example.demo.model.dtos;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class RestApiSuccessAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {

	private final long expirationTime = 3600000;
	private final String secret; 
  public RestApiSuccessAuthenticationHandler(@Value("$jwt.secret") String secret) {
		this.secret = secret;
	}




@Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
              Authentication authentication) throws IOException, ServletException {
		UserDetails principal = (UserDetails) authentication.getPrincipal();
		String token = JWT.create() 
						.withSubject(principal.getUsername()) 
						.withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
						.sign(Algorithm.HMAC256(secret)); 
		response.addHeader("Authorization", "Bearer " + token);
}
}

