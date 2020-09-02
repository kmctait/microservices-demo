package com.mctait.microservices.rest.subtraction;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubtractionController {

	protected Logger logger = Logger.getLogger(SubtractionController.class.getName());
	
	@GetMapping("/subtract/{num1}/{num2}")
	public String doAdd(@PathVariable String num1, @PathVariable String num2) {
		
		int firstNum = Integer.valueOf(num1);
		int secondNum = Integer.valueOf(num2);
		int difference = firstNum-secondNum;
		
        return "{\"num1\":\"" + num1 + "\", \"num2\":\"" + num2 + "\", \"difference\": \"" + difference + "\"}";
	}
	
}
