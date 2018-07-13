package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Client findOneById(Long id);

}
