package com.example.restservice;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import com.udojava.evalex.Expression;

public class SIUnitSingleton {
    private static SIUnitSingleton instance =null;
    private  Map<String, SIUnit> convertMap = null;
    private SIUnitSingleton(){
        this.convertMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, SIUnit>("minute", new SIUnit("s","60")),
            new AbstractMap.SimpleEntry<String, SIUnit>("min", new SIUnit("s","60")),
            new AbstractMap.SimpleEntry<String, SIUnit>("hour", new SIUnit("s","3600")),
            new AbstractMap.SimpleEntry<String, SIUnit>("h", new SIUnit("s","3600")),
            new AbstractMap.SimpleEntry<String, SIUnit>("day", new SIUnit("s","86400")),
            new AbstractMap.SimpleEntry<String, SIUnit>("d", new SIUnit("s","86400")),
            new AbstractMap.SimpleEntry<String, SIUnit>("degree", new SIUnit("rad","PI/180")),
            new AbstractMap.SimpleEntry<String, SIUnit>("°", new SIUnit("rad","PI/180")),
            new AbstractMap.SimpleEntry<String, SIUnit>("hectare", new SIUnit("m2","10000")),
            new AbstractMap.SimpleEntry<String, SIUnit>("ha", new SIUnit("m2","10000")),
            new AbstractMap.SimpleEntry<String, SIUnit>("litre", new SIUnit("m3","0.001")),
            new AbstractMap.SimpleEntry<String, SIUnit>("L", new SIUnit("m3","0.001")),
            new AbstractMap.SimpleEntry<String, SIUnit>("tonne", new SIUnit("kg","1000")),
            new AbstractMap.SimpleEntry<String, SIUnit>("t", new SIUnit("kg","1000"))
        );
    }

    public SIUnit convert2SIUnit(String unitName){
        SIUnit siunit = this.convertMap.get(unitName);
        if (siunit==null){
            return new SIUnit("Unknown","-1")
        }
    }

    public static SIUnitSingleton getInstance(){
        if (instance==null){
            instance = new SIUnitSingleton();
        }
        return instance;
    }
    public double calculate(String s) {
        // Eval : https://github.com/uklimaschewski/EvalEx
        BigDecimal result = new Expression(s).setPrecision(14).eval(); // -0.35
        return result.doubleValue();
    }


	public SIExpressionTuple parseSIExpression(String units){
		String calculateExpression="";
        String siSymbolExpression="";
		units=units.trim();
		String symbol="";
        for (int i = 0; i < units.length(); i++) {
			char c = units.charAt(i);
			if (c=='(' || c==')' || c=='*' || c=='/'){
				if (symbol.length()!=0){
					SIUnit siunit = SIUnitSingleton.getInstance().convert2SIUnit(symbol);
					calculateExpression = calculateExpression + siunit.getsiConversion();
                    siSymbolExpression = siSymbolExpression + siunit.getUnitName();
					symbol="";
				}
				calculateExpression = calculateExpression + c;
                siSymbolExpression = siSymbolExpression + c;
			}else{
				symbol = symbol + c;
			}
		}
		return new SIExpressionTuple(siSymbolExpression, calculateExpression);
	}
}