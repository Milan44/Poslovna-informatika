package com.example.bank.service;

import java.util.List;

import com.example.bank.model.AnalyticsOfStatements;

public interface IAnalyticsOfStatementsService {

	List<AnalyticsOfStatements> getAllForClearing();
}
