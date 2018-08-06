package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Clearing;

public interface IClearingService {

	List<Clearing> getAll();
	boolean save(Clearing c);
	boolean update(Clearing c);
}
