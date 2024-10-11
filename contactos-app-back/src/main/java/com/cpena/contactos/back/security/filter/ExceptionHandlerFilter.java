package com.cpena.contactos.back.security.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cpena.contactos.back.services.exceptions.BusinessException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionHandlerFilter extends OncePerRequestFilter {
	
	Logger logger = LoggerFactory.getLogger(ExceptionHandlerFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			filterChain.doFilter(request, response);
			
		}catch(BusinessException e){
			response.setStatus(e.getStatusCode().value());
			response.getWriter().write(e.getMessage());
			
		}
		
		catch(EntityNotFoundException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Username doesn't exist");
			response.getWriter().flush();
			
		}catch (RuntimeException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Bad request!!");
			response.getWriter().flush();
		}
		
	}

}
