package com.example.bank.service;

import java.util.List;

import com.example.bank.model.AnalyticsOfStatements;

public interface AnalyticsOfStatementsService {
	
	List<AnalyticsOfStatements> findAll();
	
	AnalyticsOfStatements save(AnalyticsOfStatements analytic);

	void delete (Long id);
	
	void deleteAll();
	
}
