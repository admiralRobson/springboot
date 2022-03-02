package com.example.demo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import com.example.demo.model.dtos.RestApiFailureAuthenticationHandler;
import com.example.demo.model.dtos.RestApiSuccessAuthenticationHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends
   WebSecurityConfigurerAdapter {
	
	
//	private DataSource dataSource;
	
	private final ObjectMapper objectMapper;
	
	private final RestApiFailureAuthenticationHandler failureHandler; 
	private final RestApiSuccessAuthenticationHandler succesHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
//		.dataSource()
		.withUser("test")
		.password("{bcrypt}" + new BCryptPasswordEncoder().encode("test"))
		.roles("USER");
	}		
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
//	    http.csrf().disable(); // 1
	    http
	      .authorizeRequests()
	      .antMatchers("/").permitAll() // 2
	      .antMatchers("/h2-console/**").permitAll()
	      .antMatchers("/swagger-ui.html/**").permitAll()
	      .anyRequest().authenticated()
	      .and()
	      .formLogin().permitAll()
	      .and()
	      .exceptionHandling()
	      .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));// 3
	    
	 // this will ignore only h2-console csrf, spring security 4+
        http.csrf().ignoringAntMatchers("/h2-console/**");
        //this will allow frames with same origin which is much more safe
        http.headers().frameOptions().sameOrigin();
	  }
	
	public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
		JsonObjectAuthenticationFilter authenticationFilter = new JsonObjectAuthenticationFilter(objectMapper);
		authenticationFilter.setAuthenticationFailureHandler(failureHandler);
		authenticationFilter.setAuthenticationSuccessHandler(succesHandler);
		authenticationFilter.setAuthenticationManager(super.authenticationManager());
		return authenticationFilter;
		
	}
	
}