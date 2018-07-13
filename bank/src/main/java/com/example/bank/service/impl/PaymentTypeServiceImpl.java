package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.PaymentType;
import com.example.bank.repository.PaymentTypeRepository;
import com.example.bank.service.PaymentTypeService;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService{
	
	@Autowired
	PaymentTypeRepository paymentTypeRepo;
	
	@Override
	public List<PaymentType> findAll() {
		return paymentTypeRepo.findAll();
	}

	@Override
	public PaymentType findById(Long id) {
		return paymentTypeRepo.findById(id).get();
	}

}
