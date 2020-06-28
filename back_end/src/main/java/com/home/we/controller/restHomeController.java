package com.home.we.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class restHomeController {
	
	@GetMapping(value = "/welcome2")
	public ResponseEntity<String> start() {
		System.out.println("-----");
		ResponseEntity<String> re = null;
		try {
			re = new ResponseEntity<String>("good", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("bad", HttpStatus.OK);
		}
		return re;
	}
	
	@GetMapping(value = "/click")
	public ResponseEntity<String> click() {
		ResponseEntity<String> re = null;
		try {
			re = new ResponseEntity<String>("click!!", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("bad", HttpStatus.OK);
		}
		return re;
	}
	
	@GetMapping(value = "/post/{x}")
	public ResponseEntity<String> post(@PathVariable String x) {
		ResponseEntity<String> re = null;
		System.out.println("asdasd");
		try {
			re = new ResponseEntity<String>(x, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("bad", HttpStatus.OK);
		}
		return re;
	}
}
