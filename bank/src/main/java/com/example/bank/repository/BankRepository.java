package com.example.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bank.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
	
	Bank findOneById(Long id);
	
	@Query(value="SELECT * FROM bank b where (:name is null or b.name = :name) and "
			+ "(:bankCode is null or b.bankCode = :bankCode) and "
			+ "(:pib is null or b.pib = :pib) and "
			+ "(:address is null or b.address = :address)", nativeQuery=true)
	List<Bank> searchBanks(@Param("name")String name,@Param("bankCode") String bankCode, @Param("pib") String pib, @Param("address") String address);

	
}
