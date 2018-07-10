package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.AnalyticsOfStatements;

@Repository
public interface AnalyticsOfStatementsRepository extends JpaRepository<AnalyticsOfStatements, Long>{

}
