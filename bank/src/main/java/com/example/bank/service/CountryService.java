package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Country;

public interface CountryService {
	
	List<Country> getAll();
	
	Country getCountryById(Long id);

}
