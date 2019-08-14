package com.example.springbatchexample1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springbatchexample1.model.Citizen;
import com.example.springbatchexample1.service.CitizenService;

@RestController
@RequestMapping("/Citizen")
public class CitizenController {

	private CitizenService service;

	private RestTemplate restTemplate;

	public CitizenController() {

	}

	@Autowired
	public CitizenController(CitizenService service, RestTemplate restTemplate) {
		this.service = service;
		this.restTemplate = restTemplate;
	}

	@GetMapping("/getAllCitizens")
	public ResponseEntity<Object> getAllCitizens(@RequestBody Citizen citizen) {
		return new ResponseEntity<>(service.getAllCitizen(citizen), HttpStatus.OK);
	}

	@GetMapping("/getCitizen")
	public ResponseEntity<Object> getCitizen(@RequestBody Citizen citizen) {
		return new ResponseEntity<>(service.getCitizen(citizen), HttpStatus.OK);
	}
}