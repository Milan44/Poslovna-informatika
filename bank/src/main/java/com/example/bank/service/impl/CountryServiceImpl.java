package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Country;
import com.example.bank.repository.CountryRepository;
import com.example.bank.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{


	@Autowired
	private CountryRepository countryRepository;
	
	
	
	@Override
	public List<Country> getAll() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}



	@Override
	public Country getCountryById(Long id) {
		// TODO Auto-generated method stub
		return countryRepository.findOneById(id);
	}
	

}
