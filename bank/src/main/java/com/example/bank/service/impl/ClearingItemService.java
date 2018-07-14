package com.example.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.ClearingItem;
import com.example.bank.repository.ClearingItemRepository;
import com.example.bank.service.IClearingItemService;

@Service
public class ClearingItemService implements IClearingItemService {

	@Autowired
	private ClearingItemRepository clearingItemRepository;

	@Override
	public boolean save(ClearingItem ci) {
		
		clearingItemRepository.save(ci);
		return true;
	}


	
	

}
