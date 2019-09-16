package com.passwordValidator.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.passwordValidator.config.rules.Rule;
import com.passwordValidator.config.rules.RuleTypes;
import com.passwordValidator.factory.RuleFactory;

@Component
public class RuleRepo {
	private List<Rule> defaultRuleList;
	private Set<Rule> customRules;
	@Autowired
	RuleFactory ruleFactory;
	
	
	@PostConstruct
	public void init() {
		defaultRuleList = new ArrayList<>();
		defaultRuleList.add(ruleFactory.getRule(RuleTypes.ALPHANUMERIC));
		defaultRuleList.add(ruleFactory.getRule(RuleTypes.NON_REPEATED));
		defaultRuleList.add(ruleFactory.getRule(RuleTypes.PASSWORD_LENGTH));
	}
	
	/**
	 * Creates default rules for the validator service. Currently password validation rules are:
	 * This class can be modified to get default rules from XML, Database etc.
	 * 
	 * @return
	 */
	public List<Rule> getListOfDefaultRule() {
		return defaultRuleList ;
	}
	
	public List<Rule> getCustomRules() {
		return new ArrayList<Rule>(customRules) ;
	}

	public void addRule(Rule rule) {
		if(customRules==null) {
			customRules = new HashSet<>();
		}
		customRules.add(rule);
	}

	public void remove(Rule rule) {
		// TODO Auto-generated method stub
		
	}
}
