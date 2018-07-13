package com.example.bank.service.impl;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.BankAccount;
import com.example.bank.model.DailyAccountBalance;
import com.example.bank.repository.DailyAccountBalanceRepository;
import com.example.bank.service.DailyAccountBalanceService;

@Service
public class DailyAccountBalanceServiceImpl implements DailyAccountBalanceService {
	
	private final DailyAccountBalanceRepository repository;

	@Autowired
	public DailyAccountBalanceServiceImpl(final DailyAccountBalanceRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public DailyAccountBalance findByAccountNumberAndDate(BankAccount creditorAccount, java.util.Date date) {
		String date1 = new Date(date.getTime()).toString();
		DailyAccountBalance result = repository.findByAccountNumberAndDate(creditorAccount.getAccountNumber(), date1);
		ArrayList<DailyAccountBalance> balances = null;
		if (result == null) {
			balances = repository.findByAccountNumber(creditorAccount.getAccountNumber());
			// pronalazim najblizi jer nemam u bazi svaki dan

			if (balances.size() > 0) {// ako je lista prazna, nema dnevnih
										// stanja, racun je na nuli
				DailyAccountBalance max = balances.get(0);
				for (DailyAccountBalance d : balances) {// pronalazim najblizi
														// datun
					if (d.getTrafficDate().after(max.getTrafficDate()) && d.getTrafficDate().before(date))
						max = d;
				}
				if(! max.getTrafficDate().before(date)){//zbog prvog elementa 
					result = new DailyAccountBalance();
					result.setLegalEntityAccount(creditorAccount);
					result.setNewState((float) 0.0);
					result.setPreviousState((float) 0.0);
					result.setTrafficToBenefit((float) 0.0);
					result.setTrafficToTheBurden((float) 0.0);
					result.setTrafficDate(date);
					result.setAnalyticsOfStatements(new ArrayList<AnalyticsOfStatements>());
					return result;					
				}				
				result = new DailyAccountBalance();
				result.setLegalEntityAccount(creditorAccount);
				result.setPreviousState(max.getNewState());
				result.setNewState((float) 0.0);
				result.setTrafficToBenefit((float) 0.0);
				result.setTrafficToTheBurden((float) 0.0);
				result.setTrafficDate(date);
				result.setAnalyticsOfStatements(new ArrayList<AnalyticsOfStatements>());
				return repository.save(result);

			} else {
				result = new DailyAccountBalance();
				result.setLegalEntityAccount(creditorAccount);
				result.setNewState((float) 0.0);
				result.setPreviousState((float) 0.0);
				result.setTrafficToBenefit((float) 0.0);
				result.setTrafficToTheBurden((float) 0.0);
				result.setTrafficDate(date);
				result.setAnalyticsOfStatements(new ArrayList<AnalyticsOfStatements>());
				return repository.save(result);
			}
		}
		return result;
	}

}
