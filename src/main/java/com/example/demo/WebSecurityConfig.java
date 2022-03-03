package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import com.example.demo.model.dtos.RestApiFailureAuthenticationHandler;
import com.example.demo.model.dtos.RestApiSuccessAuthenticationHandler;
import com.fasterxml.jackson.databind.ObjectMapper;



@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends
   WebSecurityConfigurerAdapter {
	
	
//	private DataSource dataSource;
	
	private final ObjectMapper objectMapper;
	private final RestApiFailureAuthenticationHandler failureHandler; 
	private final RestApiSuccessAuthenticationHandler succesHandler;
	private final String secret; 
	
	public WebSecurityConfig(ObjectMapper objectMapper, 
			RestApiFailureAuthenticationHandler failureHandler,
			RestApiSuccessAuthenticationHandler succesHandler, 
			@Value("$jwt.secret") String secret) {
		this.objectMapper = objectMapper;
		this.failureHandler = failureHandler;
		this.succesHandler = succesHandler;
		this.secret = secret;
	}
	
	
	
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
	        http.csrf().disable();
	        http
	                .authorizeRequests()
	                .antMatchers("/swagger-ui.html").permitAll()
	                .antMatchers("/v2/api-docs").permitAll()
	                .antMatchers("/webjars/**").permitAll()
	                .antMatchers("/swagger-resources/**").permitAll()
	                .antMatchers("/h2-console/**").permitAll()
	                .anyRequest().authenticated()	     
	                .and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                .and()
	                .addFilter(authenticationFilter())
	                .addFilter(new JwtAuthorizationFilter(authenticationManager(),userDetailsService(), secret))
	                .exceptionHandling()
	                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
	                .and()
	                .headers().frameOptions().disable();
	    }
	
	public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
		JsonObjectAuthenticationFilter authenticationFilter = new JsonObjectAuthenticationFilter(objectMapper);
		authenticationFilter.setAuthenticationFailureHandler(failureHandler);
		authenticationFilter.setAuthenticationSuccessHandler(succesHandler);
		authenticationFilter.setAuthenticationManager(super.authenticationManager());
		return authenticationFilter;
		
	}
	
	
}