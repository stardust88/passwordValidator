package com.passwordValidator.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * Carries validation results for each validation operation.
 * 
 * @author stardust
 *
 */
@Component
public class ValidationResult {
	
	private List<RuleResult> ruleResults;
	private Boolean isSuccess;
	
	public boolean isValidationSuccess(){
		return isSuccess;
	}
	
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public List<RuleResult> getRuleResults(){
		return ruleResults;
	}
	
	public void setRuleResult(RuleResult rule){
		if(ruleResults == null){
			ruleResults = new ArrayList<>();
		}
		ruleResults.add(rule);
	}
	

}
