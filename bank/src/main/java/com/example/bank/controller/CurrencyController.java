package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.Currency;
import com.example.bank.service.CurrencyService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/currencies")
public class CurrencyController {
	
	@Autowired
	private CurrencyService currencyService;
	
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Currency> getCurencies() {
		
		
		return currencyService.getAll();
		
	}

}
