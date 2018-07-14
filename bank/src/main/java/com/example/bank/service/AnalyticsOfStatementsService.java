package com.example.bank.service;

import java.util.ArrayList;
import java.util.List;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.BankAccount;

public interface AnalyticsOfStatementsService {
	
	List<AnalyticsOfStatements> findAll();
	
	AnalyticsOfStatements save(AnalyticsOfStatements analytic);

	void delete (Long id);
	
	void deleteAll();

	public ArrayList<AnalyticsOfStatements> findByDateAndAccount(BankAccount legalEntityAccount, java.util.Date trafficDate);
}
