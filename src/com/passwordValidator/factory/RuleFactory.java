package com.passwordValidator.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.passwordValidator.config.rules.AlphaNumericRule;
import com.passwordValidator.config.rules.CharacterLengthRule;
import com.passwordValidator.config.rules.NonRepeatedSequenceRule;
import com.passwordValidator.config.rules.Rule;
import com.passwordValidator.config.rules.RuleTypes;

@Component
public class RuleFactory {
	
	ApplicationContext applicationContext;
	
	@Autowired
	AlphaNumericRule alphaRule;
	
	@Autowired
	NonRepeatedSequenceRule nonRepeatedRule;
	
	@Autowired
	CharacterLengthRule characterRule;
	
	
	public  Rule getRule(RuleTypes ruleType) {
		Rule rule = null;
		
		switch(ruleType){
		case PASSWORD_LENGTH :
			rule = characterRule;
			break;
		case ALPHANUMERIC :
			rule = alphaRule;
			break;
		case NON_REPEATED :
			rule = nonRepeatedRule;
			break;
		default :
			break;
		}
		
		return rule;
	}

}
