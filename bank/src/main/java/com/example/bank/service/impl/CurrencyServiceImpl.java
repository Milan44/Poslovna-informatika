package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Currency;
import com.example.bank.repository.CurrencyRepository;
import com.example.bank.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService{


	@Autowired
	private CurrencyRepository currencyRepository;
	
	
	@Override
	public List<Currency> getAll() {
		// TODO Auto-generated method stub
		return currencyRepository.findAll();
	}


	@Override
	public Currency getCurrencyById(Long id) {
		// TODO Auto-generated method stub
		return currencyRepository.findOneById(id);
	}

}
