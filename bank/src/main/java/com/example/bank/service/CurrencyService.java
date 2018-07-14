package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Currency;

public interface CurrencyService {
	
	List<Currency> getAll();
	
	boolean registerCurrency(Currency c);
	
	boolean updateCurrency(Currency c);		
	
	void deleteCurrency(Long id);	
	
	Currency getCurrencyById(Long id);

}
