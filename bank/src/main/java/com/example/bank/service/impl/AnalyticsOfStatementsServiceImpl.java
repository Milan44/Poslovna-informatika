package com.example.bank.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.BankAccount;
import com.example.bank.repository.AnalyticsOfStatementsRepository;
import com.example.bank.service.AnalyticsOfStatementsService;

@Service
public class AnalyticsOfStatementsServiceImpl implements AnalyticsOfStatementsService{
	
	@Autowired
	AnalyticsOfStatementsRepository repository;
	
	
	@Override
	public List<AnalyticsOfStatements> findAll() {
		return repository.findAll();
	}


	@Override
	public AnalyticsOfStatements save(AnalyticsOfStatements analytic) {
		return repository.save(analytic);
		
	}


	@Override
	public void deleteAll() {
		
		repository.deleteAll();
		
	}


	@Override
	public void delete(Long id) {
		System.out.println("Brise id: " + id);
		repository.deleteById(id);		
	}
	
	@Override
	public ArrayList<AnalyticsOfStatements> findByDateAndAccount(BankAccount legalEntityAccount,
			java.util.Date trafficDate) {
		// TODO Auto-generated method stub
		return repository.findByDateAndAccount(legalEntityAccount.getAccountNumber(), new Date(trafficDate.getTime()));
	}

		
}
