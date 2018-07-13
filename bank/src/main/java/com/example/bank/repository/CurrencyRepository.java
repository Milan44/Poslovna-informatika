package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.Bank;
import com.example.bank.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long>{
	
	Currency findOneById(Long id);

}
