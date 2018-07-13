package com.example.bank.service;

import java.util.List;

import com.example.bank.model.BankAccount;

public interface BankAccountService {
	
	List<BankAccount> getAll();
	
	boolean registerBankAccount(BankAccount account);
	
	List<BankAccount> getAccountsByClientIDandBankID(Long clientID, Long bankID);

}
