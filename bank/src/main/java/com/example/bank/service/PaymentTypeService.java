package com.example.bank.service;

import java.util.List;

import com.example.bank.model.PaymentType;

public interface PaymentTypeService {
	List<PaymentType> findAll();
	
	PaymentType findById(Long id);
}
