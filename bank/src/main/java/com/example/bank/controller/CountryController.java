package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.Client;
import com.example.bank.model.Country;
import com.example.bank.service.CountryService;
import com.example.bank.service.PlaceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/countries")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Country>  getCountries() {
		
		
		return countryService.getAll();
		
	}

}
