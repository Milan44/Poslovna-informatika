package com.example.bank.service;

import java.util.List;

import com.example.bank.model.BankAccount;

public interface BankAccountService {
	
	List<BankAccount> getAll();
	

	boolean registerBankAccount(BankAccount account);
	
	List<BankAccount> getAccountsByClientIDandBankID(Long clientID, Long bankID);


	List<BankAccount> findByClientId(Long id, Long account);
	
	BankAccount findById (Long id);
	
	BankAccount save(BankAccount a);
	
	void deleteById(Long id);


}
