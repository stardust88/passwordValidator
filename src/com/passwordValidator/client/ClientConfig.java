package com.passwordValidator.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.passwordValidator.DefaultPasswordValidator;
import com.passwordValidator.PasswordValidator;
import com.passwordValidator.beans.RuleRepo;
import com.passwordValidator.config.SimpleRuleExecutor;
import com.passwordValidator.config.rules.AlphaNumericRule;
import com.passwordValidator.config.rules.CharacterLengthRule;
import com.passwordValidator.config.rules.NonRepeatedSequenceRule;
import com.passwordValidator.factory.RuleFactory;

@Configuration
@PropertySource("classpath:/password-validator.properties")
@ComponentScan(basePackages = {"com.passwordValidator"})
public class ClientConfig {
	@Bean
	public PasswordValidator passwordValidator() {
		return new DefaultPasswordValidator();
	}

	@Bean
	public Client client() {
		return new Client();
	}
	
	@Bean
	public RuleFactory ruleFactory() {
		return new RuleFactory();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer xxxpropertyConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public RuleRepo ruleRepo() {
		return new RuleRepo();
	}
	
	@Bean
	public SimpleRuleExecutor simpleRuleExecutor() {
		return new SimpleRuleExecutor();
	}
	
	
	@Bean
	public CharacterLengthRule characterRule() {
		return new CharacterLengthRule();
	}
	
	
	@Bean
	public AlphaNumericRule alphaNUmericRule() {
		return new AlphaNumericRule();
	}
	
	
	@Bean
	public NonRepeatedSequenceRule nonRepeatableRule() {
		return new NonRepeatedSequenceRule();
	}
	
}
