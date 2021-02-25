package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;

@RestController
public class UnitsController {
	@GetMapping("/units/si")
	public Units units(@RequestParam(value = "units", defaultValue = "(degree/minute)") String units) {
		String calculateExpression = this.parseCalculateExpression(units);
		double value = SIUnitSingleton.getInstance().calculate(calculateExpression);
		return new Units("(rad/s)", value);
	}

	public String parseCalculateExpression(String units){
		String result="";
		units=units.trim();
		String symbol="";
        for (int i = 0; i < units.length(); i++) {
			char c = units.charAt(i);
			if (c=='(' || c==')' || c=='*' || c=='/'){
				if (symbol.length()!=0){
					SIUnit siunit = SIUnitSingleton.getInstance().convert2SIUnit(symbol);
					result = result + siunit.getsiConversion();
					symbol="";
				}
				result = result + c;
			}else{
				symbol = symbol + c;
			}
		}
		return result;
	}
}
