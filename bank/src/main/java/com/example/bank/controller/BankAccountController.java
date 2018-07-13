package com.example.bank.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;  
import java.util.Date; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.bank.model.AccountForBank;
import com.example.bank.model.Bank;
import com.example.bank.DTO.BankAccountDTO;
import com.example.bank.model.BankAccount;
import com.example.bank.model.DailyAccountBalance;
import com.example.bank.service.BankAccountService;
import com.example.bank.service.BankService;
import com.example.bank.service.DailyAccountBalanceService;
import com.example.bank.service.ClientService;
import com.example.bank.service.CurrencyService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
 
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/bankAccounts")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired

	private DailyAccountBalanceService dailyAccountBalanceService;

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
	
	@RequestMapping(
			value = "/getClientAccounts/{id}/{account}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BankAccount> getClientAccounts(@PathVariable("id") Long id, @PathVariable("account") Long accountId) {						
		return bankAccountService.findByClientId(id, accountId);
	}
	
	@RequestMapping(
			value = "suspendAccount/{id}/{trasferAccount}",
			method = RequestMethod.DELETE)			
	public List<BankAccount> suspendAccount(@PathVariable("id") Long id, @PathVariable("trasferAccount") Long transferAccount){
		double trasferedMoney = bankAccountService.findById(id).getMoney();
		BankAccount trasfer = bankAccountService.findById(transferAccount);
		
		trasfer.setMoney(trasfer.getMoney() + trasferedMoney);
		bankAccountService.save(trasfer);
		
		bankAccountService.deleteById(id);
		
		return bankAccountService.getAll();
	}
	
	// NOVO
	
	@GetMapping("/pdf/{id}")
	public void exportAccountsToPdf(@PathVariable Long id) throws Exception {
		ArrayList<AccountForBank> list = new ArrayList<>();

		ArrayList<BankAccount> accounts = bankAccountService.findByBank(id);
		Bank bank = bankService.findOne(id);
		Date date = new Date();
		for (BankAccount account : accounts) {
			String clientName = "";
			if (account.getClient().getTypeOfClient().equals("fizicko lice")) {
				clientName = account.getClient().getName();
			} else {
				//clientName = ((BankAccount) account.getClient()).getNaziv_klijenta();
				clientName = account.getClient().getName();
			}
			DailyAccountBalance dailyAccountBalance = dailyAccountBalanceService.findByAccountNumberAndDate(account, new Date());
			Float state = (float) 0.0;
			if (dailyAccountBalance.getTrafficToBenefit() == 0 && dailyAccountBalance.getTrafficToTheBurden() == 0)
				state = dailyAccountBalance.getPreviousState();
			else
				state = dailyAccountBalance.getNewState();
			AccountForBank afb = new AccountForBank(clientName, account.getAccountNumber(), state.toString(),
					account.getCurrency().getOfficial_code());
			list.add(afb);
		}

		JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(list);


		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ItemDataSource", itemsJRBean);
		parameters.put("BankName", bank.getName());
		parameters.put("Date", date);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport("excerptBank.jasper", parameters, new JREmptyDataSource());
	    File file = new File("../bank/accounts.pdf");
	    OutputStream outputStream = new FileOutputStream(file);
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	
	}

}
