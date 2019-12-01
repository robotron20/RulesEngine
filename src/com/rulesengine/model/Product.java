package com.rulesengine.model;

public class Product {
	
	private String name;
	private Double interestRate;
	private boolean disqualified;
	
	public Product(String name, Double interestRate, boolean disqualified) {
		
		super();
		
		this.name = name;
		this.interestRate = interestRate;
		this.disqualified = disqualified;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public boolean isDisqualified() {
		return disqualified;
	}
	public void setDisqualified(boolean disqualified) {
		this.disqualified = disqualified;
	}	

}
