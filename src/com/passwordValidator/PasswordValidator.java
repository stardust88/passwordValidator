package com.passwordValidator;

import com.passwordValidator.beans.ValidationResult;

public interface PasswordValidator {
	
	
	/**
	 * Validates a password string with default and custom defined rules.
	 * 
	 * @param password
	 * @return
	 */
	ValidationResult validate(String password);

}
