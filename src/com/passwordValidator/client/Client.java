package com.passwordValidator.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.passwordValidator.PasswordValidator;

/**
 * Test class to display usage of password validator 
 * @author stardust
 *
 */
@Component
public class Client {
	
	@Autowired
	PasswordValidator passwordValidator;
	
	public static void main(String args[]){
	
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ClientConfig.class);
        Client client = ctx.getBean(Client.class);
        client.validatePassword("hello");
		
	}
	
	private void validatePassword(String password){
		passwordValidator.validate(password);
	}
	
	

}
