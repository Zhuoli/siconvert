package com.example.restservice;

public class SIUnit {

	private final String unitName;
	private final double siConversion;


	public SIUnit(String unitName, double siConversion) {
		this.unitName = unitName;
		this.siConversion=siConversion;
	}

	public String getUnitName() {
		return unitName;
	}

	public double getsiConversion(){
		return siConversion;
	}
}
