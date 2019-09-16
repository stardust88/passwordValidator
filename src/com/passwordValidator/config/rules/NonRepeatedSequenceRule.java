package com.passwordValidator.config.rules;

import org.springframework.stereotype.Component;

import com.passwordValidator.Constants;
import com.passwordValidator.beans.RuleResult;

/**
 * Rule to check  repeated sequence of characters.
 * 
 * @author stardust
 *
 */
@Component
public class NonRepeatedSequenceRule implements Rule{

	private String description; 

	/* (non-Javadoc)
	 * @see com.passwordValidator.config.rules.Rule#execute(java.lang.String)
	 */
	@Override
	public RuleResult execute(String password) {
		RuleResult result = new RuleResult();
		boolean isValid = true;
		
		int j =0;
		int length = password.length();

		for(int i=0;i<password.length();i++){
			j =i+1;
			while(true){
				
				if(j+(j-i)>=length){
					break;
				}
				
				if(password.substring(i, (j)).equals(password.substring(j, j+(j-i)))){
					isValid = false;
					break;
				}
				j++;
			}
			if(!isValid)
				break;
			
		}
		
		result.setValid(isValid);
		if(!result.isValid()){	
			result.setError(Constants.NON_REPEATED_RULE);
		}
		return result;
	}

}
