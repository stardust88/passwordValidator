package com.passwordValidator.beans;

import org.springframework.stereotype.Component;

/**
 * Carries result of a executed rule;
 * 
 * @author stardust
 *
 */
@Component
public class RuleResult {
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	private boolean isValid = false;
	private String error;

}
