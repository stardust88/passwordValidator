package com.passwordValidator.config.rules;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.passwordValidator.Constants;
import com.passwordValidator.beans.RuleResult;

/**
 * Checks for maximum and minimum length of a string
 * 
 * @author stardust
 *
 */
@Component
public class CharacterLengthRule implements Rule{
	int minLength;	
	int maxLength;
	
	@Autowired
	Environment environment;
	
	
	@PostConstruct
	public void init() {
		this.minLength = Integer.parseInt(environment.getProperty("MIN_LENGTH"));
		this.maxLength = Integer.parseInt(environment.getProperty("MAX_LENGTH"));
	}

	@Override
	public RuleResult execute(String password) {
		RuleResult result = new RuleResult();
		
		if(StringUtils.isEmpty(password)|| (password.length()<minLength || password.length()>maxLength)){
			result.setValid(false);
			result.setError(Constants.PASSWORD_LENGHT_RULE);
		}else{
			result.setValid(true);
		}
		
		return result;
	}

}
