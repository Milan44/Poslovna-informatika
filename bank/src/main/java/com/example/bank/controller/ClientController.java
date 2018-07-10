package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.BankAccount;
import com.example.bank.model.Client;
import com.example.bank.service.ClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client>  getCinemas() {
		
		
		return clientService.getAll();
		
	}
	
	
	@RequestMapping(
			value = "/registerClient",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean registerClient(@RequestBody Client client) {
		
		try {
			
			clientService.registerClient(client);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	

}
