package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class UnitsController {
	@GetMapping("/units/si")
	public Units units(@RequestParam(value = "units", defaultValue = "(rad/s)") String units) {
		//int value = SIUnitSingleton.getInstance().calculate2(units);
		return new Units(units, 12345);
	}
}
