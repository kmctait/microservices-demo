package com.mctait.microservices.web;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebArithmeticController {

	@Autowired
	protected WebAdditionService additionService;
	
	@Autowired
	protected WebSubtractionService subtractionService;
	
	protected Logger logger = Logger.getLogger(WebArithmeticController.class.getName());
	
	public WebArithmeticController(WebAdditionService additionService, WebSubtractionService subtractionService) {
		this.additionService = additionService;
		this.subtractionService = subtractionService;
	}
	
	
	@RequestMapping("/add")
	public String doAdd(@RequestParam String num1, @RequestParam String num2, Model model) {
		String sum = additionService.add(num1, num2);
		logger.info("Sum: " + sum);
		model.addAttribute("json", sum);
		
		return "sum";
	}
	
	@RequestMapping("/subtract")
	public String doSubtract(@RequestParam String num1, @RequestParam String num2, Model model) {
		String difference = subtractionService.subtract(num1, num2);
		logger.info("Difference: " + difference);
		model.addAttribute("json", difference);
		
		return "difference";
	}
}
