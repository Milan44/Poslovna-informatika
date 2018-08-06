package com.example.bank.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.Bank;
import com.example.bank.model.BankAccount;
import com.example.bank.model.Clearing;
import com.example.bank.model.ClearingItem;
import com.example.bank.model.DailyAccountBalance;
import com.example.bank.model.RealTimeGrossSettlement;
import com.example.bank.repository.BankAccountRepository;
import com.example.bank.repository.DailyAccountBalanceRepository;
import com.example.bank.service.AnalyticsOfStatementsService;
import com.example.bank.service.DailyAccountBalanceService;
import com.example.bank.service.IClearingItemService;
import com.example.bank.service.IClearingService;
import com.example.bank.service.IRealTimeGrossSettlementService;


@Service
@Transactional
public class DailyAccountBalanceServiceImpl implements DailyAccountBalanceService {

	private String currentBank="555";
	

	@Autowired
	private  DailyAccountBalanceRepository repository;
	
	@Autowired
	private  BankAccountRepository bankAccountRepository;
	
	@Autowired
	private AnalyticsOfStatementsService service;

	@Autowired
	private BankServiceImpl bankService;
	
	@Autowired
	private IRealTimeGrossSettlementService realTimeGrossSettlementService;

	@Autowired
	private IClearingService clearingService;
	
	@Autowired
	private IClearingItemService clearingItemService;


//	@Autowired
//	public DailyAccountBalanceServiceImpl(final DailyAccountBalanceRepository repository) {
//		this.repository = repository;
//	}

	@Override
	public List<DailyAccountBalance> findAll() {
		return (List<DailyAccountBalance>) repository.findAll();
	}

	@Override
	public DailyAccountBalance save(DailyAccountBalance dailyAccountBalance) {
		return repository.save(dailyAccountBalance);
	}


	@Override
	public DailyAccountBalance findOne(Long id) {
		return (DailyAccountBalance)repository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<DailyAccountBalance> search(DailyAccountBalance accountBalance) {
		String date = "";
		if (accountBalance.getTrafficDate() != null)
			date = new Date(accountBalance.getTrafficDate().getTime()).toString();

		String account_id = "%";
		if (accountBalance.getLegalEntityAccount().getId() != null)
			account_id = "" + accountBalance.getLegalEntityAccount().getId();

		String previuousState = "";
		if (accountBalance.getPreviousState() != null) {
			previuousState = "" + accountBalance.getPreviousState();
			String[] splitted = previuousState.split("\\.");
			if (splitted[1].equals("0"))
				previuousState = splitted[0];
		}
		String trafficToBenefit = "";
		if (accountBalance.getTrafficToBenefit() != null) {
			trafficToBenefit = "" + accountBalance.getTrafficToBenefit();
			String[] splitted = trafficToBenefit.split("\\.");
			if (splitted[1].equals("0"))
				trafficToBenefit = splitted[0];
		}
		String trafficToBurden = "";
		if (accountBalance.getTrafficToTheBurden() != null) {
			trafficToBurden = "" + accountBalance.getTrafficToTheBurden();
			String[] splitted = trafficToBurden.split("\\.");
			if (splitted[1].equals("0"))
				trafficToBurden = splitted[0];
		}
		String newState = "";
		if (accountBalance.getNewState() != null) {
			newState = "" + accountBalance.getNewState();
			String[] splitted = newState.split("\\.");
			if (splitted[1].equals("0"))
				newState = splitted[0];
		}

		return repository.search(date, previuousState, trafficToBenefit, trafficToBurden, newState, account_id);
	}


	@Override
	public void updateDebtor(AnalyticsOfStatements analytic) {
		//uvek je nalog za placanje pa se uzima debitorov nalog
		BankAccount bankAccount= bankAccountRepository.findByAccountNumber(analytic.getDebtorAccount());
		System.out.println("PRONADJEN RACUN: " + bankAccount.getAccountNumber());
		DailyAccountBalance result = findAccountStateAt(bankAccount, analytic.getDateOfReceipt());

		//prva tri broja oznacavaju banku 
//		result.getAnalyticsOfStatements().add(analytic);
//		if(result.getTrafficToBenefit() == 0 && result.getTrafficToTheBurden() == 0) {
//			result.setNewState(result.getPreviousState()-analytic.getSum());
//		}else {
			result.setNewState(result.getNewState()-analytic.getSum());
//		}
		result.setTrafficToTheBurden(result.getTrafficToTheBurden()+analytic.getSum());
		analytic.setDailyAccountBalance(result);
		result=repository.save(result);
		
		System.out.println("result:"+result);
//		DailyAccountBalance result2 = repository.findByAccountNumberAndDate(analytic.getDebtorAccount(), analytic.getDateOfReceipt().toString());
//		System.out.println("result2:"+result2);
//		analytic.setDailyAccountBalance(result2);
	}
	@Override
	public void updateCreditor(AnalyticsOfStatements analytic) {
		//uvek je nalog za placanje pa se uzima debitorov nalog
		BankAccount bankAccount= bankAccountRepository.findByAccountNumber(analytic.getAccountCreditor());
		DailyAccountBalance result = findAccountStateAt(bankAccount, analytic.getDateOfReceipt());

		//prva tri broja oznacavaju banku 
//		String bankKreditor=analytic.getAccountCreditor().substring(0, 3);
//		result.getAnalyticsOfStatements().add(analytic);
		result.setTrafficToBenefit(result.getTrafficToBenefit()+analytic.getSum());
//		if(result.getTrafficToBenefit() == 0 && result.getTrafficToTheBurden() == 0) {
//			result.setNewState(result.getPreviousState()+analytic.getSum());
//		}else {
			result.setNewState(result.getNewState()+analytic.getSum());
//		}
		analytic.setDailyAccountBalance(result);
		result=repository.save(result);
		
		System.out.println("result:"+result);
//		DailyAccountBalance result2 = repository.findByAccountNumberAndDate(analytic.getDebtorAccount(), analytic.getDateOfReceipt().toString());
//		System.out.println("result2:"+result2);
//		analytic.setDailyAccountBalance(result2);
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

	@Override
	public DailyAccountBalance findAccountStateAt(BankAccount creditorAccount, java.util.Date date) {
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
				if(! max.getTrafficDate().before(date)){
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
				//promenjeno 
//				result.setNewState((float) 0.0);
				result.setNewState((float) result.getPreviousState());
				//
				result.setTrafficToBenefit((float) 0.0);
				result.setTrafficToTheBurden((float) 0.0);
				result.setTrafficDate(date);
				result.setAnalyticsOfStatements(new ArrayList<AnalyticsOfStatements>());
				return result;

			} else {
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
		}
		return result;
	}
	
	
	
	@Override
	public List<DailyAccountBalance> findBalances(BankAccount account, java.util.Date start,
			java.util.Date end) {
		// TODO Auto-generated method stub
		Date dateStartSql= new Date(start.getTime());
		Date dateEndSql= new Date(end.getTime());
		return repository.findBalances(account.getAccountNumber(), dateStartSql, dateEndSql);
	}

	public void klasifikujAnalitiku(AnalyticsOfStatements analytics) {

		//System.out.println("POZIVA SE KLASIFIKUJ ANALITIKU!!");
		if(analytics.getAccountCreditor().isEmpty() && !analytics.getDebtorAccount().isEmpty()) { // isplata
			if (analytics.getDebtorAccount().substring(0,  3).equals(currentBank)) {
				updateDebtor(analytics);
				service.save(analytics);
				return;
			}
		}
		if(analytics.getDebtorAccount().isEmpty() && !analytics.getAccountCreditor().isEmpty()) { // uplata
			if (analytics.getAccountCreditor().substring(0,  3).equals(currentBank)) {
				updateCreditor(analytics);
				service.save(analytics);
				return;
			}
		}
		
		if(!analytics.getAccountCreditor().isEmpty() && !analytics.getDebtorAccount().isEmpty()) { // prenos izmedju racuna unutar iste banke
			if (analytics.getDebtorAccount().substring(0,  3).equals(currentBank) && analytics.getAccountCreditor().substring(0,  3).equals(currentBank)) {
				AnalyticsOfStatements analyticsCreditor= new AnalyticsOfStatements(analytics);
				updateDebtor(analytics);
				service.save(analytics);

				updateCreditor(analyticsCreditor);
				service.save(analyticsCreditor);
				return;
			 }
		}
		if (analytics.getDebtorAccount().substring(0,  3).equals(currentBank) && !analytics.getAccountCreditor().substring(0,  3).equals(currentBank)) { //medjubankarski transfer
			
			//System.out.println("POGODIO SAM IF");
			updateDebtor(analytics);
			//System.out.println("JOS SAM OVDE 1");
			service.save(analytics);
			//System.out.println("JOS SAM OVDE 2");
			
			generateInterbankTransfer(analytics);
		}
	}
	
	public void generateInterbankTransfer(AnalyticsOfStatements analytics) {
		
		//System.out.println("POZIVA SE GENERISANJE INTERBANK TRANSFERa!");
		String currentBankSwift = "55555555";
		String obracunskiRacunBankeDuznika = "555989898989812345";
		
		if (analytics.getSum() < 250000 && !analytics.getEmergency()) {	//generisanje clearing-a
			
			List<Clearing> clearings = clearingService.getAll();
			
			System.out.println("Broj clearinga:");
			System.out.println(clearings.size());
			
			ClearingItem ci = new ClearingItem();
			ci.setItemNumber(analytics.getItemNumber());
			ci.setDebtor_originator(analytics.getDebtor_originator());
			ci.setPurposeOfPayment(analytics.getPurposeOfPayment());
			ci.setCreditor_recipient(analytics.getCreditor_recipient());
			ci.setDateOfReceipt(analytics.getDateOfReceipt());
			ci.setCurrencyDate(analytics.getCurrencyDate());
			ci.setDebtorAccount(analytics.getDebtorAccount());
			ci.setModelAssigments(analytics.getModelAssigments());
			ci.setReferenceNumberAssigments(analytics.getReferenceNumberAssigments());
			ci.setReferenceNumberCreditor(analytics.getReferenceNumberCreditor());
			ci.setAccountCreditor(analytics.getAccountCreditor());
			ci.setModelApproval(analytics.getModelApproval());
			ci.setIznos(analytics.getSum());
			ci.setSifraValute(analytics.getPaymentCurrency().getOfficial_code());
			
			clearingItemService.save(ci);
			
			boolean pronadjen = false;
			for (Clearing clearing : clearings) {
				
				if (clearing.getPoveriocObracunskiRacun().substring(0,  3).equals(analytics.getAccountCreditor().substring(0,  3)) && !clearing.getExportovan()) {
					
					List<ClearingItem> items = clearing.getNalozi();
					items.add(ci);
					clearing.setNalozi(items);
					clearing.setUkupanIznos(clearing.getUkupanIznos() + ci.getIznos());
					
					clearingService.save(clearing);
					
					pronadjen = true;
					
					break;
					
				}
			}
			
			if (!pronadjen) {
				
				
				Random rand = new Random();
				int porukaID = rand.nextInt(1000) + 1;
				
				List<Bank> banks = bankService.getAll();
				
				Clearing cl = new Clearing();
				
				cl.setPorukaID(porukaID + "");
				cl.setDuznikSWIFT(currentBankSwift);
				cl.setDuznikObracunskiRacun(obracunskiRacunBankeDuznika);
				
				for (Bank bank : banks) {
					
					if (bank.getRacun().substring(0, 3).equals(analytics.getAccountCreditor().substring(0, 3))) {
						
						cl.setPoverilacSWIFT(bank.getSwift());
						cl.setPoveriocObracunskiRacun(bank.getRacun());
						break;
					}
				}
				
//				double ukupanIznos = 0;
//				for (ClearingItem clearingItem : cl.getNalozi()) {
//					
//					ukupanIznos += clearingItem.getIznos();
//				}
				cl.setUkupanIznos(ci.getIznos());
				cl.setSifraValute(analytics.getPaymentCurrency().getOfficial_code());
				cl.setDatumValute(analytics.getCurrencyDate());
				cl.setDatum(analytics.getDateOfReceipt());
				cl.setExportovan(false);
				
				List<ClearingItem> items = cl.getNalozi();
				items.add(ci);
				cl.setNalozi(items);
				
				clearingService.save(cl);
			}
			
			
		} else if (analytics.getSum() >= 250000 || analytics.getEmergency()) { //generisanje rtgs-a
			
			Random rand = new Random();
			int porukaID = rand.nextInt(1000) + 1;
			
			List<Bank> banks = bankService.getAll();
			
			
			
			RealTimeGrossSettlement rtgs = new RealTimeGrossSettlement();
			rtgs.setPorukaID(porukaID + "");
			rtgs.setDuznikSWIFT(currentBankSwift);
			rtgs.setDuznikObracunskiRacun(obracunskiRacunBankeDuznika);
			
			for (Bank bank : banks) {
				
				if (bank.getRacun().substring(0, 3).equals(analytics.getAccountCreditor().substring(0, 3))) {
					
					rtgs.setPoverilacSWIFT(bank.getSwift());
					rtgs.setPoveriocObracunskiRacun(bank.getRacun());
					break;
				}
			}
			
			rtgs.setDuznik(analytics.getDebtor_originator());
			rtgs.setSvrhaPlacanja(analytics.getPurposeOfPayment());
			rtgs.setPoverilac(analytics.getCreditor_recipient());
			rtgs.setDatumNaloga(analytics.getDateOfReceipt());
			rtgs.setDatumValute(analytics.getCurrencyDate());
			rtgs.setDuznikRacun(analytics.getDebtorAccount());
			rtgs.setModelZaduzenja(new Long(analytics.getModelAssigments()));
			rtgs.setPozivNaBrojZaduzenja(analytics.getReferenceNumberAssigments());
			rtgs.setPoverlacRacun(analytics.getAccountCreditor());
			rtgs.setModelOdobrenja(new Long(analytics.getModelApproval()));
			rtgs.setPozivNaBrojOdobrenja(analytics.getReferenceNumberCreditor());
			rtgs.setIznos(analytics.getSum());
			rtgs.setSifraValute(analytics.getPaymentCurrency().getOfficial_code());
			
			realTimeGrossSettlementService.registerRTGS(rtgs);
			exportRTGS(rtgs);
		}
	}
	
	public void exportRTGS(RealTimeGrossSettlement rtgs) {
			
			System.out.println("JA SAM POZVANAAAAAA");
			String xmlString = "";
		    try {
		        JAXBContext context = JAXBContext.newInstance(RealTimeGrossSettlement.class);
		        Marshaller m = context.createMarshaller();
	
		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
	
		        StringWriter sw = new StringWriter();
		        m.marshal(rtgs, sw);
		        xmlString = sw.toString();
	
		    } catch (JAXBException e) {
		        e.printStackTrace();
		    }
		    System.out.println(xmlString);		
		    
		    BufferedWriter bw = null;
			FileWriter fw = null;
		    
		    String filename = "rtgs-" + rtgs.getPorukaID() +".xml";
		    try{
		    	Path path = Paths.get("generisaniMedjubankarski");
		    	fw = new FileWriter(path.toString() + "\\" + filename);		    	
		    	bw = new BufferedWriter(fw);
		    	bw.write(xmlString);
		    	
		    } catch (IOException ex) {
	
				ex.printStackTrace();
	
			} finally {
				try {
	
					if (bw != null)
						bw.close();
	
					if (fw != null)
						fw.close();					
						
	
				} catch (IOException ex) {
	
					ex.printStackTrace();
	
				}
			}
	}

}