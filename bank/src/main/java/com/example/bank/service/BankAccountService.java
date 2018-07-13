package com.example.bank.service;

import java.util.ArrayList;
import java.util.List;

import com.example.bank.model.BankAccount;

public interface BankAccountService {
	
	List<BankAccount> getAll();
	
	boolean registerCinema(BankAccount account);
	
	ArrayList<BankAccount> findByBank(Long id);
	
	List<BankAccount> findByClientId(Long id, Long account);
	
	BankAccount findById (Long id);
	
	BankAccount save(BankAccount a);
	
	void deleteById(Long id);

}
