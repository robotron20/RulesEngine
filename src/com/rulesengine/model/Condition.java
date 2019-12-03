package com.rulesengine.model;

import java.lang.reflect.Method;

public class Condition {
	
	private String objectType;
	private String fieldType;	
	private String compareType;
	private String dataType;
	private String value;
	
	public Condition(String objectType, String fieldType, String compareType, String dataType, String value) {
		
		super();
		
		this.objectType = objectType;
		this.fieldType = fieldType;
		this.compareType = compareType;
		this.dataType = dataType;
		this.value = value;
		
	}
	
	public boolean isValid(Person person, Product product) {
					
		if (objectType.equals("Person")) {
			
			return perform(person);
			
		}
		else if (objectType.equals("Product")) {
			
			return perform(product);
			
		}
		
		return false;
		
	}
	
	private boolean perform(Object object) {
		
		try {
			
			Class objectClass = Class.forName("com.rulesengine.model." + objectType);
			Method getMethod = objectClass.getDeclaredMethod("get" + fieldType);
			
			Object methodValue = getMethod.invoke(object);
			
			if (dataType.equals("String")) {
				
				String tempValue = (String)methodValue;
				
				if (compareType.equals("Equal") && (value.equals(tempValue))) {					
					return true;
				}
				else if (compareType.equals("NotEqual") && (!value.equals(tempValue))) {
					return true;
				}
				
			}
			else if (dataType.equals("Boolean")) {
				
				Boolean boolValue = Boolean.valueOf(value);
				Boolean tempValue = (Boolean)methodValue;
				
				if (compareType.equals("Equal") && (boolValue == tempValue)) {					
					return true;
				}
				else if (compareType.equals("NotEqual") && (boolValue != tempValue)) {
					return true;
				}
				
			}
			else if (dataType.equals("Integer")) {
				
				Integer intValue = Integer.valueOf(value);
				Integer tempValue = (Integer)methodValue;
				
				if (compareType.equals("Equal") && (intValue == tempValue)) {					
					return true;
				}
				else if (compareType.equals("NotEqual") && (intValue != tempValue)) {					
					return true;
				}
				else if (compareType.equals("LessThan") && (intValue < tempValue)) {
					return true;
				}
				else if (compareType.equals("GreaterThan") && (intValue > tempValue)) {
					return true;
				}
				else if (compareType.equals("LessEqual") && (intValue <= tempValue)) {
					return true;
				}
				else if (compareType.equals("GreaterEqual") && (intValue >= tempValue)) {
					return true;
				}
				
			}
			else if (dataType.equals("Double")) {
				
				Double doubleValue = Double.valueOf(value);
				Double tempValue = (Double)methodValue;
				
				if (compareType.equals("Equal") && (doubleValue == tempValue)) {					
					return true;
				}
				else if (compareType.equals("NotEqual") && (doubleValue != tempValue)) {					
					return true;
				}
				else if (compareType.equals("LessThan") && (doubleValue < tempValue)) {
					return true;
				}
				else if (compareType.equals("GreaterThan") && (doubleValue > tempValue)) {
					return true;
				}
				else if (compareType.equals("LessEqual") && (doubleValue <= tempValue)) {
					return true;
				}
				else if (compareType.equals("GreaterEqual") && (doubleValue >= tempValue)) {
					return true;
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
}
