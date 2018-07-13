package com.example.bank.controller;

import java.util.List;
import java.text.SimpleDateFormat;  
import java.util.Date; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.DTO.BankAccountDTO;
import com.example.bank.model.BankAccount;
import com.example.bank.service.BankAccountService;
import com.example.bank.service.BankService;
import com.example.bank.service.ClientService;
import com.example.bank.service.CurrencyService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/bankAccounts")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CurrencyService currencyService;
	
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BankAccount>  getBankAccounts() {
		
		
		return bankAccountService.getAll();
		
	}
	
	
	@RequestMapping(
			value = "/registerBankAccount",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean registerBankAccount(@RequestBody BankAccountDTO accountDTO) {
		
		try {
			
			BankAccount account = new BankAccount();
			account.setAccountNumber(accountDTO.getAccountNumber());
			account.setDateOfOpening(new SimpleDateFormat("yyyy-MM-dd").parse(accountDTO.getDateOfOpening()));
			account.setMoney(accountDTO.getMoney());
			account.setValid(accountDTO.getValid());
			
			account.setClient(clientService.getClientById(accountDTO.getClientID()));
			account.setBank(bankService.getBankById(accountDTO.getBankID()));
			account.setCurrency(currencyService.getCurrencyById(accountDTO.getCurrencyID()));
			
			bankAccountService.registerBankAccount(account);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}

}
