package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Bank;
import com.example.bank.repository.BankRepository;
import com.example.bank.service.BankService;

@Service
public class BankServiceImpl implements BankService{

	private final BankRepository bankRepository;
	
	@Autowired
	public BankServiceImpl(final BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}
	
	
	@Override
	public List<Bank> getAll() {
		// TODO Auto-generated method stub
		return bankRepository.findAll();
	}
	
/*	@Override
	public List<Bank> findAll() {
		return (List<Bank>) bankRepository.findAll();
	}
*/	
	@Override
	public Bank findOne(Long id) {
		return (Bank)bankRepository.findById(id).get();
	}

}
