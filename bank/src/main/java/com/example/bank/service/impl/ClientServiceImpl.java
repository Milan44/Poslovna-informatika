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
	public boolean registerClient(Client c) {
		// TODO Auto-generated method stub
		clientRepository.save(c);
		return true;
	}

	@Override
	public boolean updateClient(Client c) {
		Client client = clientRepository.findOneById(c.getId());
		
		client.setAddress(c.getAddress());
		client.setPhone(c.getPhone());
		client.setFax(c.getFax());
		client.setEmail(c.getEmail());
		client.setAddressForStatements(c.getAddressForStatements());
		client.setEmailStatements(c.getEmailStatements());
		client.setName(c.getName());
		client.setJmbg(c.getJmbg());
		client.setTypeOfClient(c.getTypeOfClient());
		client.setResidence(c.getResidence());
		client.setPib(c.getPib());
		client.setLegalEntityAccount(c.getLegalEntityAccount());
			
		clientRepository.flush();
		
		return true;
	}

	@Override
	public void deleteClient(Long id) {
		
		clientRepository.deleteById(id);
		
	}

	@Override
	public Client getClientById(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findOneById(id);
	}

}
