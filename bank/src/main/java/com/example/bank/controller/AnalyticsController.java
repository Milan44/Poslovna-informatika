package com.example.bank.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
//import java.sql.Date;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.AccountStatement;
import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.BankAccount;
import com.example.bank.model.DailyAccountBalance;
import com.example.bank.service.AnalyticsOfStatementsService;
import com.example.bank.service.DailyAccountBalanceService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/public/analytics")
public class AnalyticsController {

	@Autowired
	private AnalyticsOfStatementsService service;
	
	@Autowired
	private DailyAccountBalanceService dailyAccountBalanceService;
	
	@Autowired
	private AnalyticsOfStatementsService analyticsOfStatementsService;

	@SuppressWarnings("deprecation")
	@RequestMapping(
			value = "/load", 	
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AnalyticsOfStatements>loadAnalytics(@RequestBody String putanjaClient) {		
		
		/*List<AnalyticsOfStatements> analitike = service.findAll();
				
		for(AnalyticsOfStatements analitika: analitike){
			
			String xmlString = "";
		    try {
		        JAXBContext context = JAXBContext.newInstance(AnalyticsOfStatements.class);
		        Marshaller m = context.createMarshaller();

		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

		        StringWriter sw = new StringWriter();
		        m.marshal(analitika, sw);
		        xmlString = sw.toString();

		    } catch (JAXBException e) {
		        e.printStackTrace();
		    }
		    System.out.println(xmlString);		
		    
		    BufferedWriter bw = null;
			FileWriter fw = null;
		    
		    String putanja = "Analytic-" + analitika.getItemNumber().toString() +".xml";
		    try{
		    	//f = new File("C:\\filename.txt");
		    	fw = new FileWriter("E:\\Analytics\\" + putanja);		    	
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
		 
		} */
		
		System.out.println("PUTANJA JE: " + putanjaClient);
			
		
		File[] files = new File(putanjaClient).listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		long time = System.currentTimeMillis();
		Date current = new Date(time);

		service.deleteAll();
		for (File file : files) {
		    
		    	JAXBContext jaxbContext;
				try {
					jaxbContext = JAXBContext.newInstance(AnalyticsOfStatements.class);
					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			    	AnalyticsOfStatements analyticParsed = (AnalyticsOfStatements) jaxbUnmarshaller.unmarshal(file);
			    	
//			    	analyticParsed.setDateOfReceipt(current);
			    //	analyticParsed.setCurrencyDate(current);

			    	updateDailyAccountBalance(analyticParsed);			    	
//			    	service.save(analyticParsed);
			    	

			    	BankAccount ba=new BankAccount();
			    	ba.setAccountNumber(analyticParsed.getDebtorAccount());
			    	exportXml(new Date(117, 1, 1), new Date(118, 12, 1),ba);
			    	
			    	String currentBank="555";
			    	String bankKreditor=analyticParsed.getAccountCreditor().substring(0, 3);
			    	String bankDebitor=analyticParsed.getDebtorAccount().substring(0, 3);
			    	
				} catch (JAXBException e) {					 
					e.printStackTrace();
				}
		    	
		}
		List<AnalyticsOfStatements> analitike = service.findAll(); 
		return service.findAll();
		//return null;
		
	}
	
	@DeleteMapping
	public void deleteAnalytics() {
		
		System.out.println("POGODIO BRISANJE");
		
		List<AnalyticsOfStatements> analytics = service.findAll();
		
		for(AnalyticsOfStatements a: analytics){
			service.delete(a.getItemNumber());
		}
	}
	
	private void updateDailyAccountBalance(AnalyticsOfStatements analytic) {
		dailyAccountBalanceService.updateDebtor(analytic);
	}
	
	private void  exportXml(Date startDate,Date endDate, BankAccount legalEntityAccount)  throws JAXBException{
		
		ArrayList<DailyAccountBalance> dailyAccountBalances = (ArrayList<DailyAccountBalance>) dailyAccountBalanceService.findBalances(legalEntityAccount, startDate, endDate);
		AccountStatement accountStatement = new AccountStatement(startDate,endDate,legalEntityAccount.getAccountNumber());
		//		Balances balances = new Balances();
		if(dailyAccountBalances.size()>0) {
				DailyAccountBalance firstBalance=dailyAccountBalances.get(0);
				DailyAccountBalance lastBalance=dailyAccountBalances.get(0);

			
			for(DailyAccountBalance d : dailyAccountBalances){
				ArrayList<AnalyticsOfStatements> analyticsOfStatements = analyticsOfStatementsService.findByDateAndAccount(legalEntityAccount,d.getTrafficDate());
//				for(AnalyticsOfStatements a : analyticsOfStatements)
//					d.getAnalyticsOfStatements().add(a);
//				
				if(d.getTrafficDate().before(firstBalance.getTrafficDate())) {
					firstBalance=d;
				}
				
				if(d.getTrafficDate().after(lastBalance.getTrafficDate())) {
					lastBalance=d;
				}
				accountStatement.getDailyBalances().add(d);
				accountStatement.getStatements().addAll(0, d.getAnalyticsOfStatements());
				
			}
			
			accountStatement.setStartAccountState(firstBalance.getPreviousState());
			accountStatement.setStateAtTheEndOfPeriod(lastBalance.getNewState());

		}
		
		File file = new File("C:\\Users\\JOVICA\\Desktop\\files\\statements.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(AccountStatement.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(accountStatement, file);
		jaxbMarshaller.marshal(accountStatement, System.out);
	}
}
