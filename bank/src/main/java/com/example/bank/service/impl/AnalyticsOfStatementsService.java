package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.repository.AnalyticsOfStatementsRepository;
import com.example.bank.service.IAnalyticsOfStatementsService;

@Service
public class AnalyticsOfStatementsService implements IAnalyticsOfStatementsService {

	@Autowired
	private AnalyticsOfStatementsRepository analyticsOfStatementsRepository;
	
	@Override
	public List<AnalyticsOfStatements> getAllForClearing() {
		
		return analyticsOfStatementsRepository.findAllForClearing();
	}

}
