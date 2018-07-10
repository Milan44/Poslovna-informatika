package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.ItemTransfer;

@Repository
public interface ItemTransferRepository extends JpaRepository<ItemTransfer, Long>{

}
