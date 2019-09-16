package com.passwordValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.passwordValidator.beans.RuleRepo;
import com.passwordValidator.beans.ValidationResult;
import com.passwordValidator.config.SimpleRuleExecutor;
import com.passwordValidator.config.rules.Rule;
import com.passwordValidator.config.rules.RuleTypes;
import com.passwordValidator.factory.RuleFactory;

/**
 * Default Password validator. Class is responsible for validating user input with default rules and custom rules.
 * 
 * Default rules are:
 * 	 Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
�*   Must be between 5 and 12 characters in length.
�*   Must not contain any sequence of characters immediately followed by the same sequence.
 * 
 * @author stardust
 *
 */
@Component
public class DefaultPasswordValidator implements PasswordValidator {


	final static Logger logger = Logger.getLogger(DefaultPasswordValidator.class);

	
	@Autowired
	SimpleRuleExecutor executor;
	
	@Autowired
	RuleRepo ruleRepo;
	

	/* (non-Javadoc)
	 * @see com.passwordValidator.PasswordValidator#validate(java.lang.String)
	 */
	@Override
	public ValidationResult validate(String password) {
		return executor.execute(password);
	}

	
	/**
	 * Add a custom rule to be applied
	 * @param rule
	 * @param name
	 */
	public void addRule(Rule rule) {
		ruleRepo.addRule(rule);
	}

	/**
	 * Delete custom rule with a given name
	 * 
	 * @param ruleName
	 */
	public void deleteRule(Rule rule) {
		ruleRepo.remove(rule);
	}
}
