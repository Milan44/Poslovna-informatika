package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Client;

public interface ClientService {
	
	List<Client> getAll();
	
	
	boolean registerClient(Client client);
	
	boolean updateClient(Client client);		
	
	void deleteClient(Long id);
	
	Client getClientById(Long id);
	

}
