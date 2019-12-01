package com.rulesengine.model;

enum Type {
	
	INIT,
	CONDITION
	
}

public class Rule {
	
	private Type type;
	
	private String objectName;
	private String fieldName;
	private String value;
	
}
