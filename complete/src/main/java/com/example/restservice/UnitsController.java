package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitsController {

	@GetMapping("/units/si")
	public Units units(@RequestParam(value = "units", defaultValue = "(rad/s)") String units) {
		return new Units(units, 0.00029088820866572);
	}
}
