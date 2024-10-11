package com.cpena.contactos.back.security.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cpena.contactos.back.services.IBusiness.IUserService;
import com.cpena.contactos.back.services.business.UserServiceImpl;
import com.cpena.contactos.back.services.dtos.users.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomAuthenticationManager implements AuthenticationManager{
	
	Logger logger = LoggerFactory.getLogger(CustomAuthenticationManager.class);
	
	public CustomAuthenticationManager() {
		System.out.println("creando customAuthenticationManager");
	}
	
	@Autowired
	private IUserService userServiceImpl;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {		
		UserDto userDto = userServiceImpl.getUserByEmail(authentication.getName());
		
		if(!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), userDto.getPassword())) {
			logger.info("las credenciales no son las mismas");
			throw new BadCredentialsException("Password is not correct");
			
		}			
		
		return new UsernamePasswordAuthenticationToken(authentication.getName(), userDto.getPassword() );
	}

}
