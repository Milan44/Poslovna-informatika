package com.example.bank.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bank.model.DailyAccountBalance;

@Repository
public interface DailyAccountBalanceRepository extends PagingAndSortingRepository<DailyAccountBalance, Long>{

	@Query("select d from DailyAccountBalance d where d.legalEntityAccount.accountNumber like :accountNumber and d.trafficDate like CONCAT(:date,'%')")
	public DailyAccountBalance findByAccountNumberAndDate(@Param("accountNumber")String accountNumber,@Param("date")String date);
	
	@Query("select d from DailyAccountBalance d where d.legalEntityAccount.accountNumber like :accountNumber")
	public ArrayList<DailyAccountBalance> findByAccountNumber(@Param("accountNumber")String accountNumber);

}
