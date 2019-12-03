package com.rulesengine.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.rulesengine.model.Action;
import com.rulesengine.model.Condition;
import com.rulesengine.model.Rule;


public class CSVLoader implements Loader {
	
	@Override
	public ArrayList<Rule> load(File file) throws Exception {
		
		ArrayList<Rule> ruleList = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		
		Rule rule = new Rule();
		  
		String line; 
		
		while ((line = br.readLine()) != null) {
			
			String[] tokenList = line.split(",");
			
			String ruleType = tokenList[0];
			
			if (ruleType.equals("Action")) {
				
				String commandType = tokenList[1];
				String objectType = tokenList[2];
				String fieldType = tokenList[3];
				String dataType = tokenList[4];
				String value = tokenList[5];
				
				Action action = new Action(objectType, fieldType, commandType, dataType, value);				
				rule.setAction(action);
				
				ruleList.add(rule);
				
				rule = new Rule();
				
			}
			else if (ruleType.equals("Condition")) {
								
				String objectType = tokenList[1];
				String fieldType = tokenList[2];				
				String compareType = tokenList[3];
				String dataType = tokenList[4];
				String value = tokenList[5];
				
				Condition condition = new Condition(objectType, fieldType, compareType, dataType, value);
				rule.setCondition(condition);
				
			}
			
			System.out.println(line);
			
		}
		
		return ruleList;
		
	}

}

