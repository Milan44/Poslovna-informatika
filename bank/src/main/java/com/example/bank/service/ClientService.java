package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Client;

public interface ClientService {
	
	List<Client> getAll();
	
	
	boolean registerClient(Client client);
	
	boolean updateClient(Client client);		
	
	void deleteClient(Long id);
	
	Client getClientById(Long id);	

	List<Client> searchClients(String address, String addressForStatements, String email, String fax, String jmbg,
			String name, String phone, String pib, String typeOfClient, Long residence);
	

}
