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


	@Override
	public boolean registerCurrency(Currency c) {
		// TODO Auto-generated method stub
		currencyRepository.save(c);
		return true;
	}


	@Override
	public boolean updateCurrency(Currency c) {
		// TODO Auto-generated method stub
		Currency currency = currencyRepository.findOneById(c.getId());
		currency.setCountry(c.getCountry());
		currency.setDomicilna(c.getDomicilna());
		currency.setName(c.getName());
		currency.setOfficial_code(c.getOfficial_code());
		
		return true;
	}


	@Override
	public void deleteCurrency(Long id) {
		// TODO Auto-generated method stub
		currencyRepository.deleteById(id);
		
	}

}
