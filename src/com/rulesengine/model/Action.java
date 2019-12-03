package com.rulesengine.model;

import java.lang.reflect.Method;

public class Action {
	
	private String objectType;	
	private String fieldType;
	private String commandType;
	private String dataType;
	private String value;
	
	public Action(String objectType, String fieldType, String commandType, String dataType, String value) {
		
		super();
		
		this.objectType = objectType;
		this.fieldType = fieldType;
		this.commandType = commandType;
		this.dataType = dataType;
		this.value = value;
		
	}
		
	public void perform(Person person, Product product) {
		
		if (objectType.equals("Person")) {
			
			perform(person);
			
		}
		else if (objectType.equals("Product")) {
			
			perform(product);
			
		}
		
	}
	
	private void perform(Object object) {
		
		try {
			
			Class objectClass = Class.forName("com.rulesengine.model." + objectType);
			Method getMethod = objectClass.getDeclaredMethod("get" + fieldType);
			
			Object methodValue = getMethod.invoke(object);
			
			System.out.println(commandType);
			
			if (commandType.equals("Set")) {
				
				if (dataType.equals("String")) {
					
					Method setMethod = objectClass.getDeclaredMethod("set" + fieldType, String.class);
					setMethod.invoke(object, value);
					
				}
				else if (dataType.equals("Boolean")) {
					
					Method setMethod = objectClass.getDeclaredMethod("set" + fieldType, Boolean.class);
					setMethod.invoke(object, Boolean.valueOf(value));
					
				}
				else if (dataType.equals("Integer")) {
					
					Method setMethod = objectClass.getDeclaredMethod("set" + fieldType, Integer.class);
					setMethod.invoke(object, Integer.valueOf(value));
					
				}
				else if (dataType.equals("Double")) {
					
					Method setMethod = objectClass.getDeclaredMethod("set" + fieldType, Double.class);
					setMethod.invoke(object, Double.valueOf(value));
					
				}
				
			}
			else if (commandType.equals("Add")) {
				
				if (dataType.equals("Integer")) {
					
					Integer intValue = Integer.valueOf(value);
					Integer tempValue = (Integer)methodValue;
					
					Integer newValue = tempValue + intValue;

					Method setMethod = objectClass.getDeclaredMethod("set" + fieldType, Integer.class);
					setMethod.invoke(object, newValue);
					
				}
				else if (dataType.equals("Double")) {
					
					Double doubleValue = Double.valueOf(value);
					Double tempValue = (Double)methodValue;
					
					Double newValue = tempValue + doubleValue;
					
					Method setMethod = objectClass.getDeclaredMethod("set" + fieldType, Double.class);
					setMethod.invoke(object, newValue);
					
				}
				
				
			}
			else if (commandType.equals("Subtract")) {
				
				if (dataType.equals("Integer")) {
					
					Integer intValue = Integer.valueOf(value);
					Integer tempValue = (Integer)methodValue;
					
					Integer newValue = tempValue - intValue;
					
					Method setMethod = objectClass.getDeclaredMethod("set" + fieldType, Integer.class);
					setMethod.invoke(object, newValue);
					
				}
				else if (dataType.equals("Double")) {
					
					Double doubleValue = Double.valueOf(value);
					Double tempValue = (Double)methodValue;
					
					Double newValue = tempValue - doubleValue;
					
					Method setMethod = objectClass.getDeclaredMethod("set" + fieldType, Double.class);
					setMethod.invoke(object, newValue);
					
				}
								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
