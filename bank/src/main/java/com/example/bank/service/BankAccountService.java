package com.example.bank.service;

import java.util.List;

import com.example.bank.model.BankAccount;

public interface BankAccountService {
	
	List<BankAccount> getAll();
	
	boolean registerCinema(BankAccount account);
	List<BankAccount> findByClientId(Long id);

}
