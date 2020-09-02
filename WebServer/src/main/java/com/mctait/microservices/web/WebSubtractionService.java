package com.mctait.microservices.web;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebSubtractionService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	protected String serviceUrl;
	protected Logger logger = Logger.getLogger(WebSubtractionService.class.getName());
	
	public WebSubtractionService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}
	
	public String subtract(String num1, String num2) {
		return restTemplate.getForObject(serviceUrl + "/subtract/{num1}/{num2}", String.class, num1, num2);
	}
	
}
