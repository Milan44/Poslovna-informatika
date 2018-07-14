package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Clearing;
import com.example.bank.repository.ClearingRepository;
import com.example.bank.service.IClearingService;

@Service
public class ClearingService implements IClearingService {

	@Autowired
	private ClearingRepository clearingRepository;
	
	@Override
	public List<Clearing> getAll() {
		
		return clearingRepository.findAll();
	}

	@Override
	public boolean save(Clearing c) {
		
		clearingRepository.save(c);
		return true;
	}

}
