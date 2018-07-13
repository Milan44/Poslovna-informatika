package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.Bank;
import com.example.bank.model.Client;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
	
	Bank findOneById(Long id);

}
