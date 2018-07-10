package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.InterbankTransfer;

@Repository
public interface InterbankTransferRepository extends JpaRepository<InterbankTransfer, Long>{

}
