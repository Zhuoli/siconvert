package com.example.restservice;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SIUnitSingleton {
    private static SIUnitSingleton instance =null;
    private  HashMap<String, String> convertMap = null;
    private SIUnitSingleton(){
        // this.convertMap = Map.ofEntries(
        //     new AbstractMap.SimpleEntry<String, SIUnit>("minute", new SIUnit("s",60)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("min", new SIUnit("s",60)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("hour", new SIUnit("s",3600)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("h", new SIUnit("s",3600)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("day", new SIUnit("s",86400)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("d", new SIUnit("s",86400)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("degree", new SIUnit("rad",Math.PI/180)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("°", new SIUnit("rad",Math.PI/180))
        // );
    }

    // public SIUnit convert2SIUnit(String unitName){
    //     return this.convertMap.get(unitName);
    // }

    public static SIUnitSingleton getInstance(){
        if (instance==null){
            instance = new SIUnitSingleton();
        }
        return instance;
    }
    public int calculate(String s) {
        int l2 = 1, o2 = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }

                l2 = (o2 == 1 ? l2 * num : l2 / num);

            } else if (c == '(') {
                int j = i;

                for (int cnt = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(') cnt++;
                    if (s.charAt(i) == ')') cnt--;
                    if (cnt == 0) break;
                }

                int num = calculate(s.substring(j + 1, i));

                l2 = (o2 == 1 ? l2 * num : l2 / num);

            } else if (c == '*' || c == '/') {
                o2 = (c == '*' ? 1 : -1);

            } 
        }

        return l2;
    }
}