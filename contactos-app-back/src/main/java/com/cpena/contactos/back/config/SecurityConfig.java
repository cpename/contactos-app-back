package com.cpena.contactos.back.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.cpena.contactos.back.constants.Constants;
import com.cpena.contactos.back.security.filter.AuthenticationFilter;
import com.cpena.contactos.back.security.filter.ExceptionHandlerFilter;
import com.cpena.contactos.back.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;



@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
	
	private BCryptPasswordEncoder passwordEncoder;
	
	private CustomAuthenticationManager customAuthenticationManager;
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
		authenticationFilter.setFilterProcessesUrl(Constants.BASE_URI + "/authentication");
//		ExceptionHandlerFilter exceptionHandlerFilter = new ExceptionHandlerFilter();
		
	 	http
	 		.csrf( (csrf) -> csrf.disable() )
	 		.authorizeHttpRequests(
	 				(authorizationManagerRequestMatcherReistry) -> authorizationManagerRequestMatcherReistry
//		 				.requestMatchers(HttpMethod.DELETE, "contacts/api/users/delete/*/user").hasRole("ADMIN")		 		
//				 		.requestMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
//				 		.requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
			 		.requestMatchers(HttpMethod.POST, Constants.REGISTER_PATH).permitAll()
			 		.requestMatchers(HttpMethod.GET).permitAll()
			 		.requestMatchers(HttpMethod.PUT).permitAll()
			 		.anyRequest().authenticated()
			 		
			 		
	 		)		 		
	 		.httpBasic(Customizer.withDefaults())	 		
	 		.addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
	 		.addFilter(authenticationFilter)	 		
	 		.sessionManagement(
	 				(httpSecuritySessionManagementeConfigure) ->
	 				httpSecuritySessionManagementeConfigure.sessionCreationPolicy(SessionCreationPolicy.STATELESS)  
	 		);
	 	
	 	
	 	return http.build();
    }
	 
	 @Bean
	 public UserDetailsService userDetailsService() {		 
		 UserDetails admin = User.builder()				 
				 .username("admin")
				 .password(passwordEncoder.encode("admin-pass"))
				 .roles("ADMIN", "USER")
				 .build();
		 
		 UserDetails user = User.builder()
				 .username("user")
				 .password(passwordEncoder.encode("user-pass"))
				 .roles("USER")
				 .build();
		 
		 return new InMemoryUserDetailsManager(admin, user);
				 
	}
	 
//	 @Bean
	 public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		 AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		 authenticationManagerBuilder
		 	.userDetailsService(userDetailsService())
		 	.passwordEncoder(passwordEncoder);		 
		 return authenticationManagerBuilder.build();
		 
		 
	 }
	
//	@Bean
//	public AuthenticationManager authenticationManager( HttpSecurity httpSecurity, PasswordEncoder passwordEncoder, 
//			BCryptPasswordEncoder bCryptPasswordEncoder ) throws Exception {
//		return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
//				.userDetailsService(userDetailsService())
//				.passwordEncoder(bCryptPasswordEncoder)
//				.and()
//				.build();
//				
//				
//		
//	} 
//	 
	

}
