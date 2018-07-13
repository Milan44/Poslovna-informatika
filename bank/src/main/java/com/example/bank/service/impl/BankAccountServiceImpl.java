package com.example.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.BankAccount;
import com.example.bank.repository.BankAccountRepository;
import com.example.bank.repository.BankRepository;
import com.example.bank.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Override
	public List<BankAccount> getAll() {
		// TODO Auto-generated method stub
		return bankAccountRepository.findAll();
	}

	@Override
	public boolean registerBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		bankAccountRepository.save(account);
		return true;
	}

	@Override
	public List<BankAccount> getAccountsByClientIDandBankID(Long clientID, Long bankID) {
		// TODO Auto-generated method stub
		return bankAccountRepository.findAccountsByClientIDandBankID(clientID, clientID);
	}

	@Override
	public List<BankAccount> findByClientId(Long id, Long account) {
		List<BankAccount> allAccounts = bankAccountRepository.findAll();
		List<BankAccount> ret = new ArrayList<BankAccount>();
		
		for(BankAccount acc: allAccounts){
			if(acc.getClient().getId().compareTo(id)==0 && acc.getId().compareTo(account) != 0){
				ret.add(acc);
				//System.out.println(acc.getClient());
				//System.out.println(acc.getMoney());
			}
		}
		
		return ret;
	}

	@Override
	public BankAccount findById(Long id) {
		return bankAccountRepository.findById(id).get();
	}

	@Override
	public BankAccount save(BankAccount a) {
		return bankAccountRepository.save(a);
	}

	@Override
	public void deleteById(Long id) {
		bankAccountRepository.deleteById(id);

	}



}