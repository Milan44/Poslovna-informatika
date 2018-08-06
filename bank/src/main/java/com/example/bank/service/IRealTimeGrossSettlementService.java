package com.example.bank.service;

import java.util.List;

import com.example.bank.model.RealTimeGrossSettlement;

public interface IRealTimeGrossSettlementService {

	boolean registerRTGS(RealTimeGrossSettlement rtgs);
	List<RealTimeGrossSettlement> getAll();
}
