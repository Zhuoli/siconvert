package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitsController {

	private static final String TEMPLATE = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/units/si")
	public Units units(@RequestParam(value = "units", defaultValue = "World") String units) {
		return new Units(counter.incrementAndGet(), String.format(TEMPLATE, units), 0.00029088820866572);
	}
}
