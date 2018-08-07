package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.Clearing;

@Repository
public interface ClearingRepository extends JpaRepository<Clearing, Long> {

	Clearing findOneByClearingId(Long id);
}
