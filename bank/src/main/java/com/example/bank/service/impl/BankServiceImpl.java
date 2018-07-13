package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Bank;
import com.example.bank.repository.BankRepository;
import com.example.bank.service.BankService;

@Service
public class BankServiceImpl implements BankService{

	
	@Autowired
	private BankRepository bankRepository;
	
	@Override
	public List<Bank> getAll() {
		// TODO Auto-generated method stub
		return bankRepository.findAll();
	}

	@Override
	public Bank getBankById(Long id) {
		// TODO Auto-generated method stub
		return bankRepository.findOneById(id);
	}

	@Override
	public boolean registerBank(Bank bank) {
		// TODO Auto-generated method stub
		bankRepository.save(bank);
		return true;
	}
	
	@Override
	public Bank findOne(Long id) {
		return (Bank)bankRepository.findById(id).get();
	}
}

