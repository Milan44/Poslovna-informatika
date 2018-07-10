package com.example.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan("com.example.bank.model") 
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		System.out.println("Hello mavene Jodza!");
	}
}
