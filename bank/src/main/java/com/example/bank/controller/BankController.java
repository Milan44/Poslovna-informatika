package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.Bank;
import com.example.bank.service.AnalyticsOfStatementsService;
import com.example.bank.service.BankService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/banks")
public class BankController {

	@Autowired
	private BankService bankService;
	
	@Autowired
	private AnalyticsOfStatementsService service;
	
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bank>  getCinemas() {
		
		return bankService.getAll();
		//return bankService.findAll();
		
	}
	
	@RequestMapping(
			value = "/load", 	
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AnalyticsOfStatements>loadAnalytics() {			
		return service.findAll();
		
	}
	
}

