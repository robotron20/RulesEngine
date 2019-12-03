package com.rulesengine.model;

public class Person {

	private Integer creditScore;
	private String state;
	
	public Person(Integer creditScore, String state) {
		
		super();
		
		this.creditScore = creditScore;
		this.state = state;
		
	}
	
	public Integer getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String toString() {
		return "Credit Score: " + creditScore + " State: " + state;
	}
	
}
