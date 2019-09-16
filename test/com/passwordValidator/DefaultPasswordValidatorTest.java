package com.passwordValidator;

import org.junit.Test;

import junit.framework.Assert;

public class DefaultPasswordValidatorTest {
	
	@Test
	public void testDefaultPasswordValidatorFailCase(){
		Assert.assertEquals(new DefaultPasswordValidator().validate("TestPassword").isValidationSuccess(),false);
		
	}
	@Test
	public void testDefaultPasswordValidatorSuccessCase(){
		Assert.assertEquals(new DefaultPasswordValidator().validate("a4f5g6k8990").isValidationSuccess(),true);
		
	}
	
	

}
