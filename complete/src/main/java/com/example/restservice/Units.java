package com.example.restservice;

public class Units {

	private final String unitName;
	private final double multiplicationFactor;

	public Units(String unitName, double multiplicationFactor) {
		this.unitName = unitName;
		this.multiplicationFactor=multiplicationFactor;
	}

	public String getUnitName() {
		return unitName;
	}

	public double getMultiplicationFactor(){
		return multiplicationFactor;
	}
}
