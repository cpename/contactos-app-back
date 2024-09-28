package com.cpena.contactos.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 	http
		 		.csrf( (csrf) -> csrf.disable() )
		 		.authorizeHttpRequests(
		 				(authorizationManagerRequestMatcherReistry) -> authorizationManagerRequestMatcherReistry
		 				.requestMatchers(HttpMethod.DELETE, "contacts/api/users/delete/*/user").hasRole("ADMIN")		 		
				 		.requestMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
				 		.requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
				 		.requestMatchers(HttpMethod.GET).permitAll()
				 		.anyRequest().authenticated()				 		
				 		
		 		)		 		
		 		.httpBasic(Customizer.withDefaults())		 		
		 		.sessionManagement(
		 				(httpSecuritySessionManagementeConfigure) ->
		 				httpSecuritySessionManagementeConfigure.sessionCreationPolicy(SessionCreationPolicy.STATELESS)  
		 		);
		 	
		 	
		 	return http.build();
	    }
	 
	 @Bean
	 public UserDetailsService users() {		 
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

}
