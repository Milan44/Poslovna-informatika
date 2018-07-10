package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.BankAccount;
import com.example.bank.repository.BankAccountRepository;
import com.example.bank.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Override
	public List<BankAccount> getAll() {
		// TODO Auto-generated method stub
		return bankAccountRepository.findAll();
	}

	@Override
	public boolean registerCinema(BankAccount account) {
		// TODO Auto-generated method stub
		bankAccountRepository.save(account);
		return true;
	}

}
