package com.example.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bank.model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{
	
	@Query(value = "SELECT * FROM bankaccount ba where ba.client_client_id = :client_id", nativeQuery=true)
	public List<BankAccount> findAccountsByClientID(@Param("client_id") Long client_id);

}
