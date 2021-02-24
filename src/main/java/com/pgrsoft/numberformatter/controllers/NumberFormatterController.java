package com.pgrsoft.numberformatter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.numberformatter.services.NumberFormatter;

@RestController
@CrossOrigin
@RequestMapping("/number-name")
public class NumberFormatterController {

	@Autowired
	private NumberFormatter numberFormatter;
	
	@GetMapping("/{number}")
	public String convert(@PathVariable int number) {
		return numberFormatter.convert(number);
	}
	
}
