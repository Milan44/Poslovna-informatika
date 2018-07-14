package com.example.bank.service;

import java.util.Date;
import java.util.List;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.BankAccount;
import com.example.bank.model.DailyAccountBalance;


public interface DailyAccountBalanceService {
	List<DailyAccountBalance> findAll();

	DailyAccountBalance save(DailyAccountBalance dailyAccountBalance);

	DailyAccountBalance findOne(Long id);
	
	public void delete(Long id);
	
	public List<DailyAccountBalance> search(DailyAccountBalance accountBalance);
	public List<DailyAccountBalance> findBalances(BankAccount account,Date start,Date end);

	DailyAccountBalance findByAccountNumberAndDate(BankAccount creditorAccount,Date date);

	DailyAccountBalance findAccountStateAt(BankAccount creditorAccount, Date date);

	void  update(AnalyticsOfStatements analytic);
}
