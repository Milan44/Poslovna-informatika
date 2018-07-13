package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Bank;
import com.example.bank.model.Client;

public interface BankService {
	
	List<Bank> getAll();
	
	Bank getBankById(Long id);

}
