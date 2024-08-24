package com.cpena.contactos.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class ContactosAppBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactosAppBackApplication.class, args);
	}
	
//	/**
//	 * configuration custom validation message fuente: https://www.baeldung.com/spring-custom-validation-message-source
//	 * @return MessageSource 
//	 */
//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		
//		messageSource.setBasename("classpath:messages");
//		messageSource.setDefaultEncoding("UTF-8");
//		
//		return messageSource();
//	}
//	
//	@Bean
//	public LocalValidatorFactoryBean getValidator() {
//		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//		bean.setValidationMessageSource(messageSource());
//		
//		return bean;
//	}

}
