package com.cpena.contactos.back.security.filter;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cpena.contactos.back.constants.Constantes;
import com.cpena.contactos.back.security.manager.CustomAuthenticationManager;
import com.cpena.contactos.back.services.dtos.users.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
	private CustomAuthenticationManager customAuthenticationManager;
	
	public AuthenticationFilter( CustomAuthenticationManager customAuthenticationManager ) {
		this.customAuthenticationManager = customAuthenticationManager;
	}
		

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
				
		try {
			UserDto userDto = new ObjectMapper().readValue(request.getInputStream(), UserDto.class);
			log.info("user email: {}" , userDto.getEmail());
			log.info("user password: {}", userDto); 
			Authentication  authentication = new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword());
			
			return	customAuthenticationManager.authenticate(authentication);
			
		}catch(IOException e) {
			throw new RuntimeException();
		}
		
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write(failed.getMessage());
		response.getWriter().flush();
		
	}


	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		log.info("user authenticated: {}", authResult.getName());		
		String token = JWT.create()
				.withSubject(authResult.getName())
				.withIssuedAt(Date.from(Instant.now()))
				.withClaim("scope", "admins")
				.withExpiresAt(new Date(System.currentTimeMillis() + Constantes.TOKEN_EXPIRATION_30_MINUTES))
				.sign(Algorithm.HMAC512(Constantes.SECRET_KEY));
		
		response.addHeader(Constantes.AUTHORIZATION, Constantes.BEARER + token);
				
	
	}
	
	
	
	

}
