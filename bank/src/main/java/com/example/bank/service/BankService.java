package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Bank;

public interface BankService {

	List<Bank> getAll();
	
	//List<Bank> findAll();
	
	//boolean registerBank(Bank bank);
	
	public Bank findOne(Long id);
}
