package com.rulesengine.controller;

import java.util.ArrayList;

import com.rulesengine.model.Action;
import com.rulesengine.model.Condition;
import com.rulesengine.model.Person;
import com.rulesengine.model.Product;
import com.rulesengine.model.Rule;

public class RulesEngine {

	public void runRules(Person person, Product product, ArrayList<Rule> ruleList) {
		
		for (Rule rule : ruleList) {
			
			Condition condition = rule.getCondition();
			
			if (condition.isValid(person, product)) {
				
				Action action = rule.getAction();
				action.perform(person, product);
				
			}
						
		}
		
	}
	
};