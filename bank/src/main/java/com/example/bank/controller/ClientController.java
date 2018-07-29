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

import com.example.bank.DTO.ClientDTO;
import com.example.bank.model.BankAccount;
import com.example.bank.model.Client;
import com.example.bank.model.Place;
import com.example.bank.service.BankAccountService;
import com.example.bank.service.ClientService;
import com.example.bank.service.PlaceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@Autowired
	private PlaceService placeService;
	
	
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client>  getClients() {
		
		
		return clientService.getAll();
		
	}
	
	
	@RequestMapping(
			value = "/registerClient",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean registerClient(@RequestBody ClientDTO clientDTO) {
		
		try {
			Place residence = placeService.getPlaceById(clientDTO.getResidenceID());
			
			Client client = new Client();
			client.setAddress(clientDTO.getAddress());
			client.setAddressForStatements(clientDTO.getAddressForStatements());
			client.setEmail(clientDTO.getEmail());
			client.setEmailStatements(clientDTO.getEmailStatements());
			client.setFax(clientDTO.getFax());
			client.setJmbg(clientDTO.getJmbg());
			client.setName(clientDTO.getName());
			client.setPhone(clientDTO.getPhone());
			client.setPib(clientDTO.getPib());
			client.setResidence(residence);
			client.setTypeOfClient(clientDTO.getTypeOfClient());
			
			clientService.registerClient(client);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}	
		
	}
	
	@RequestMapping(
			value = "/searchClient",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> searchClient(@RequestBody ClientDTO client) {
		
		return clientService.searchClients(client.getAddress(),client.getAddressForStatements(),client.getEmail(),client.getFax(),
				client.getJmbg(), client.getName(), client.getPhone(), client.getPib(), client.getTypeOfClient(), client.getResidenceID());
	}
	
	
	@RequestMapping(
			value = "/updateClient",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateClient(@RequestBody ClientDTO clientDTO){
	 
		
		System.out.println("POGODJEN CONTROLLER /update");
		try {
			Place residence = placeService.getPlaceById(clientDTO.getResidenceID());
			
			Client client = clientService.getClientById(clientDTO.getId());
			client.setId(clientDTO.getId());
			client.setAddress(clientDTO.getAddress());
			client.setAddressForStatements(clientDTO.getAddressForStatements());
			client.setEmail(clientDTO.getEmail());
			client.setEmailStatements(clientDTO.getEmailStatements());
			client.setFax(clientDTO.getFax());
			client.setJmbg(clientDTO.getJmbg());
			client.setName(clientDTO.getName());
			client.setPhone(clientDTO.getPhone());
			client.setPib(clientDTO.getPib());
			client.setResidence(residence);
			client.setTypeOfClient(clientDTO.getTypeOfClient());
			
			clientService.updateClient(client);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	@RequestMapping(
			value = "/deleteClient/{clientID}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public  boolean deleteClient(@PathVariable("clientID") Long clientID){
		
		System.out.println("Controller: " + clientID);
		
			
		List<BankAccount> accounts = bankAccountService.getAccountsByClientID(clientID);
		
		if(accounts.isEmpty()) {						// ako nema ni jedan racun u toj banci onda tek moze da ga obrise
			clientService.deleteClient(clientID);
			
			return true;
			
		} else {
			
			return false;
			
		}
		
		
			

	}
	

}
