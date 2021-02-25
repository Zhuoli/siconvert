package com.example.restservice;

public class SIExpressionTuple {
    private final String sIUnitExpression;
	private final String calculateExpression;


	public SIExpressionTuple(String sIUnitExpression, String calculateExpression) {
		this.sIUnitExpression = sIUnitExpression;
		this.calculateExpression=calculateExpression;
	}

	public String getSIUnitExpression() {
		return sIUnitExpression;
	}

	public String getCalculateExpression(){
		return calculateExpression;
	}
}
