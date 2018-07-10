package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.Suspension;

@Repository
public interface SuspensionRepository extends JpaRepository<Suspension, Long>{

}
