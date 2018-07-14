package com.example.bank.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bank.model.AnalyticsOfStatements;

@Repository
public interface AnalyticsOfStatementsRepository extends JpaRepository<AnalyticsOfStatements, Long>{

	@Query("SELECT aos FROM AnalyticsOfStatements aos WHERE aos.sum < 250000 AND aos.emergency = 0")
	List<AnalyticsOfStatements> findAllForClearing();

	@Query("select a from AnalyticsOfStatements a where (a.debtorAccount like :brojRacuna or a.accountCreditor like :brojRacuna) and a.currencyDate = :date")
	public ArrayList<AnalyticsOfStatements> findByDateAndAccount(@Param("brojRacuna")String brojRacuna,@Param("date") Date date);

}
