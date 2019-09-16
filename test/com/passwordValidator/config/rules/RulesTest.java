package com.passwordValidator.config.rules;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.passwordValidator.client.ClientConfig;

import junit.framework.Assert;

public class RulesTest {
	
	AnnotationConfigApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new AnnotationConfigApplicationContext(ClientConfig.class);
	}
	
	@Test
	public void testChareacterLengthRule(){
		CharacterLengthRule rule = ctx.getBean(CharacterLengthRule.class);
		Assert.assertEquals(rule.execute("TestString").isValid(), false);
		Assert.assertEquals(rule.execute("TestString1234").isValid(), true);
	}
	
	@Test
	public void testChareacterLengthRule2(){	
		CharacterLengthRule rule = ctx.getBean(CharacterLengthRule.class);
		Assert.assertEquals(rule.execute("TestString1234").isValid(), true);
	}
	
	@Test
	public void testAlphaNumericRule1(){
		AlphaNumericRule rule = ctx.getBean(AlphaNumericRule.class);
		Assert.assertEquals(rule.execute("@##%^qwdwed677").isValid(),false);
	}
	
	@Test
	public void testAlphaNumericRule2() {
		AlphaNumericRule rule = ctx.getBean(AlphaNumericRule.class);
		Assert.assertEquals(rule.execute("testonlylower").isValid(),true);
	}
	
	@Test
	public void testNonSequeceCharsFailCase(){
		NonRepeatedSequenceRule rule = ctx.getBean(NonRepeatedSequenceRule.class);
		Assert.assertEquals(rule.execute("hello").isValid(), false);
	}
	
	@Test
	public void testNonSequeceCharsPassCase(){
		
		NonRepeatedSequenceRule rule = ctx.getBean(NonRepeatedSequenceRule.class);
		Assert.assertEquals(rule.execute("abcde").isValid(), true);
	}

}
