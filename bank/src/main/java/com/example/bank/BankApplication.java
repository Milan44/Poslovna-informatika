package com.example.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.repository.AnalyticsOfStatementsRepository;
import com.example.bank.service.StorageService;


@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan("com.example.bank.model") 
public class BankApplication implements CommandLineRunner  {
	
	@Autowired
	StorageService storageService;
	
	public static void main(String[] args) {		
		SpringApplication.run(BankApplication.class, args);
		System.out.println("Hello mavene Jodza!");
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}
}
