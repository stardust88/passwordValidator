package com.passwordValidator.config.rules;

import com.passwordValidator.beans.RuleResult;

public interface Rule {
	
	/**
	 * Executes a rule on the given string
	 * 
	 * @param password: input string
	 * @return
	 */
	RuleResult execute(String password);
	
}
