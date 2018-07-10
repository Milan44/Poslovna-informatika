package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.CurrencyRate;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long>{

}
