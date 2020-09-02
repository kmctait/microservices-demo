package com.mctait.microservices.rest.addition;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

	protected Logger logger = Logger.getLogger(AdditionController.class.getName());
	
	@RequestMapping("/add/{num1}/{num2}")
	public String doAdd(@PathVariable String num1, @PathVariable String num2) {
		
		int firstNum = Integer.valueOf(num1);
		int secondNum = Integer.valueOf(num2);
		int sum = firstNum+secondNum;
		
        return "{\"num1\":\"" + num1 + "\", \"num2\":\"" + num2 + "\", \"sum\": \"" + sum + "\"}";
	}
	
}
