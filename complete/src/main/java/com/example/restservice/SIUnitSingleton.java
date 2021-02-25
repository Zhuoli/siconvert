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
            new AbstractMap.SimpleEntry<String, SIUnit>("minute", new SIUnit("s",60)),
            new AbstractMap.SimpleEntry<String, SIUnit>("min", new SIUnit("s",60)),
            new AbstractMap.SimpleEntry<String, SIUnit>("hour", new SIUnit("s",3600)),
            new AbstractMap.SimpleEntry<String, SIUnit>("h", new SIUnit("s",3600)),
            new AbstractMap.SimpleEntry<String, SIUnit>("day", new SIUnit("s",86400)),
            new AbstractMap.SimpleEntry<String, SIUnit>("d", new SIUnit("s",86400)),
            new AbstractMap.SimpleEntry<String, SIUnit>("degree", new SIUnit("rad",Math.PI/180)),
            new AbstractMap.SimpleEntry<String, SIUnit>("°", new SIUnit("rad",Math.PI/180))
        );
    }

    public SIUnit convert2SIUnit(String unitName){
        return this.convertMap.get(unitName);
    }

    public static SIUnitSingleton getInstance(){
        if (instance==null){
            instance = new SIUnitSingleton();
        }
        return instance;
    }
    public double calculate(String s) {
        // A more complex expression showing support for unary operators.
        BigDecimal result = new Expression(s).setPrecision(14).eval(); // -0.35
        return result.doubleValue();
    }
}