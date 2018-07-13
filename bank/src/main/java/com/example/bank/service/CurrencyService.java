package com.example.bank.service;

import java.util.List;


import com.example.bank.model.Currency;

public interface CurrencyService {
	
	List<Currency> getAll();
	
	Currency getCurrencyById(Long id);

}
