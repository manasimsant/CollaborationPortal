package com.niit.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/demo")
	public ResponseEntity<String> demoImpl() {

		System.out.println("----Demo Restful API");
		return new ResponseEntity("Welcome to rest controller", HttpStatus.OK);

	}

}