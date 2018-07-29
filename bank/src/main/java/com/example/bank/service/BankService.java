
package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Bank;


public interface BankService {
	
	List<Bank> getAll();
	
	Bank getBankById(Long id);
	
	boolean registerBank(Bank bank);

	public Bank findOne(Long id);

	List<Bank> searchBanks(String name, String bankCode, String pib, String address);
}
