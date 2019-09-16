package com.passwordValidator.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.passwordValidator.beans.RuleRepo;
import com.passwordValidator.beans.ValidationResult;

/**
 * @author stardust
 * 
 *         Class responsible for executing rules in serial fashion.
 *
 */
@Component
public class SimpleRuleExecutor  {

	final static Logger logger = Logger.getLogger(SimpleRuleExecutor.class);
	
	@Autowired
	RuleRepo ruleRepo;


	public ValidationResult execute(String password) {
		ValidationResult result = new ValidationResult();

		logger.info("Executing default rules");
		ruleRepo.getListOfDefaultRule().forEach(rule -> result.setRuleResult(rule.execute(password)));

		if (!CollectionUtils.isEmpty(ruleRepo.getCustomRules())) {
			logger.info("Executing custom rules");
			ruleRepo.getCustomRules().forEach(rule -> result.setRuleResult(rule.execute(password)));
		}

		long invalidCount = result.getRuleResults().stream().filter(rule -> !(rule.isValid())).count();

		if (invalidCount > 0) {
			result.setIsSuccess(false);
		} else {
			result.setIsSuccess(true);
		}
		logger.info("Validation Success:" + result.isValidationSuccess());

		return result;
	}
}
