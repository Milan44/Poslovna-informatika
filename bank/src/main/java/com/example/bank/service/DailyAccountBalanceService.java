package com.example.bank.service;

import java.util.Date;

import com.example.bank.model.BankAccount;
import com.example.bank.model.DailyAccountBalance;

public interface DailyAccountBalanceService {

	DailyAccountBalance findByAccountNumberAndDate(BankAccount creditorAccount, Date date);
	
}
