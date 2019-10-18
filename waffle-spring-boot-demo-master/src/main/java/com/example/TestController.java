package com.example;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TestController {
	
	@RequestMapping
	public String test(Authentication auth) {
		return String.format("You are logged in as: %s", auth.getPrincipal());
	}
	
	@GetMapping("/username")
	public String getName(Authentication auth) {
		return String.format(auth.getName());
	}
	
	@GetMapping("/details")
	public String details(Authentication auth) throws JsonProcessingException {
		return String.format((new ObjectMapper()).writeValueAsString(auth));
	}
}
