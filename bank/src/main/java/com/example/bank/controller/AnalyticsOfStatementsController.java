package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.Client;
import com.example.bank.service.IAnalyticsOfStatementsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/analytics")
public class AnalyticsOfStatementsController {

	@Autowired
	private IAnalyticsOfStatementsService analyticsOfStatementsService;
	
	@RequestMapping(
			value = "/getAllForClearing", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AnalyticsOfStatements>  getAllForClearing() {
		
		
		return analyticsOfStatementsService.getAllForClearing();
		
	}
}
