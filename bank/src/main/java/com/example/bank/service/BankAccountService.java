package com.example.bank.service;

import java.util.ArrayList;
import java.util.List;

import com.example.bank.model.BankAccount;

public interface BankAccountService {
	
	List<BankAccount> getAll();
	

	boolean registerBankAccount(BankAccount account);
	

	List<BankAccount> getAccountsByClientID(Long clientID);

	ArrayList<BankAccount> findByBank(Long id);
	
	List<BankAccount> getAccountsByClientIDandBankID(Long clientID, Long bankID);



	List<BankAccount> findByClientId(Long id, Long account);
	
	BankAccount findById (Long id);
	
	BankAccount save(BankAccount a);
	
	void deleteById(Long id);
	
	BankAccount findByAccNumber(String number);

	List<BankAccount> searchBankAccounts(String accountNumber, double money, Long clientID, Long bankId, Long currencyID);

}
