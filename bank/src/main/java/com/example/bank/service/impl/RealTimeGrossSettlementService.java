package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.RealTimeGrossSettlement;
import com.example.bank.repository.RealTimeGrossSettlementRepository;
import com.example.bank.service.IRealTimeGrossSettlementService;

@Service
public class RealTimeGrossSettlementService implements IRealTimeGrossSettlementService{

	@Autowired
	private RealTimeGrossSettlementRepository realTimeGrossSettlementRepository;
	@Override
	public boolean registerRTGS(RealTimeGrossSettlement rtgs) {
		System.out.println("RTGS UPIS U BAZU SE POZVAO");
		realTimeGrossSettlementRepository.save(rtgs);
		return true;
	}
	@Override
	public List<RealTimeGrossSettlement> getAll() {
		
		return realTimeGrossSettlementRepository.findAll();
	}

}
