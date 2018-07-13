package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.BankAccount;
import com.example.bank.model.Client;
import com.example.bank.service.BankAccountService;
import com.example.bank.service.ClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	
	
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
	
	
	@RequestMapping(
			value = "/updateClient",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateClient(@RequestBody Client c){
	 
		
		System.out.println("POGODJEN CONTROLLER /update");
		try {
			
			clientService.updateClient(c);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	@RequestMapping(
			value = "/deleteClient/{clientID}/{bankID}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public  boolean deleteClient(@PathVariable("clientID") Long clientID, @PathVariable("bankID") Long bankID){
		
		System.out.println("Controller: " + clientID);
		
			
		List<BankAccount> accounts = bankAccountService.getAccountsByClientIDandBankID(clientID, bankID);
		
		if(accounts.isEmpty()) {						// ako nema ni jedan racun u toj banci onda tek moze da ga obrise
			clientService.deleteClient(clientID);
			
			return true;
			
		} else {
			
			return false;
			
		}
		
		
			

	}
	

}
