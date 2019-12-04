package com.rulesengine.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.rulesengine.loader.CSVLoader;
import com.rulesengine.loader.Loader;
import com.rulesengine.model.Person;
import com.rulesengine.model.Product;
import com.rulesengine.model.Rule;

class RulesEngineTest extends RulesEngine {
	
	private static final double DELTA = 1e-1;
	
	private RulesEngine rulesEngine = new RulesEngine();
	private ArrayList<Rule> ruleList;

	@Test
	void test() {
		
		try {
			
			String path = "./rules/rules1.csv";
			File file = new File(path);
			
			
			Loader loader = new CSVLoader();
			
			ruleList = loader.load(file);
			
			Person person = new Person(720, "Florida");
			Product product = new Product("7-1 ARM", 5.0, false);
			
			rulesEngine.runRules(person, product, ruleList);
			
			assertEquals(product.getInterestRate(), Double.parseDouble("5.2"), DELTA);
			assertEquals(product.getDisqualified(), Boolean.parseBoolean("true"));
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
