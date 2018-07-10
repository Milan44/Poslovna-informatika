package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Client;

import com.example.bank.repository.ClientRepository;
import com.example.bank.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public boolean registerClient(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
		return true;
	}

}
