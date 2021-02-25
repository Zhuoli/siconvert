package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;

@RestController
public class UnitsController {
	@GetMapping("/units/si")
	public Units units(@RequestParam(value = "units", defaultValue = "(degree/minute)") String units) {
		SIExpressionTuple siExpression =  SIUnitSingleton.getInstance().parseSIExpression(units);
		double value = SIUnitSingleton.getInstance().calculate(siExpression.getCalculateExpression());
		return new Units(siExpression.getSIUnitExpression(), value);
	}

}
