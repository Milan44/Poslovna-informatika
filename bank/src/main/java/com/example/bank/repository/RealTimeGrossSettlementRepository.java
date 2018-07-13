package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.RealTimeGrossSettlement;

@Repository
public interface RealTimeGrossSettlementRepository extends JpaRepository<RealTimeGrossSettlement, Long> {

}
