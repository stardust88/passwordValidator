package com.passwordValidator.config.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.passwordValidator.Constants;
import com.passwordValidator.beans.RuleResult;

/**
 * Rule to check Alphanumeric presentation of a string
 * 
 * @author stardust
 *
 */
@Component
public class AlphaNumericRule implements Rule {

	private Pattern letterAndDigit = Pattern.compile("^[a-z0-9]*$");
	
	
	@Override
	public RuleResult execute(String password) {

		RuleResult result = new RuleResult();
		Matcher matcher = letterAndDigit.matcher(password);
		result.setValid(matcher.find());
		if (!result.isValid()) {
			result.setError(Constants.ALPHANUMERIC_RULE);
		}
		return result;
	}
}
