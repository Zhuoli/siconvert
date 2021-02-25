package com.example.restservice;

public class SIUnit {

	private final String unitName;
	private final String siConversion;


	public SIUnit(String unitName, String siConversion) {
		this.unitName = unitName;
		this.siConversion=siConversion;
	}

	public String getUnitName() {
		return unitName;
	}

	public String getsiConversion(){
		return siConversion;
	}
}
