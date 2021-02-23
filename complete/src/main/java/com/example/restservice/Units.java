package com.example.restservice;

public class Units {

	private final long id;
	private final String unitName;
	private final double multiplicationFactor;

	public Units(long id, String unitName, double multiplicationFactor) {
		this.id = id;
		this.unitName = unitName;
		this.multiplicationFactor=multiplicationFactor;
	}

	public long getId() {
		return id;
	}

	public String getUnitName() {
		return unitName;
	}

	public double getMultiplicationFactor(){
		return multiplicationFactor;
	}
}
