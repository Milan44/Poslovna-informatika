package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.AnalyticsOfStatements;
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

}
