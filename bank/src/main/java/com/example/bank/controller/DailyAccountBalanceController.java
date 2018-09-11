package com.example.bank.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.support.AnnotationConfigContextLoaderUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.example.bank.model.AccountStatement;
import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.BankAccount;
import com.example.bank.model.DailyAccountBalance;
import com.example.bank.service.AnalyticsOfStatementsService;
import com.example.bank.service.BankAccountService;
import com.example.bank.service.DailyAccountBalanceService;
import com.example.bank.service.StorageService;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("dailyAccountBalance")
public class DailyAccountBalanceController {

	private final DailyAccountBalanceService dailyAccountBalanceService;
	private final BankAccountService bankAccountService;
	private final StorageService storageService;
	private String currentBank = "555";
//	private final AnalyticsOfStatementsService analyticsOfStatementsService;
	private final Path rootLocation = Paths.get("download-daily-dir");


	@Autowired
	public DailyAccountBalanceController(final DailyAccountBalanceService service,
			final BankAccountService legalEntityAccountService,
			final StorageService storageService
			) {
		this.dailyAccountBalanceService = service;
		this.bankAccountService = legalEntityAccountService;
		this.storageService= storageService;
	}

	@GetMapping
	public ResponseEntity<List<DailyAccountBalance>> findAll() {
		return new ResponseEntity<>(dailyAccountBalanceService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody DailyAccountBalance dailyAccountBalance) {
		dailyAccountBalanceService.save(dailyAccountBalance);
	}
	
	@GetMapping("/deleteDailyAccountBalance/{id}")
	public List<DailyAccountBalance> deleteBank(@PathVariable Long id){
		dailyAccountBalanceService.delete(id);
		
		return dailyAccountBalanceService.findAll();
	}
	
	@GetMapping("/nextLegalEntityAccount/{legalEntityAccountId}")
	public List<DailyAccountBalance> nextLegalEntityAccount(@PathVariable Long legalEntityAccountId){
		BankAccount legalEntityAccount = bankAccountService.findById(legalEntityAccountId);
		
		return legalEntityAccount.getDailyAccountBalances();
	}
	
	@PostMapping("/search")
	public List<DailyAccountBalance> search(@RequestBody DailyAccountBalance dailyAccountBalance){
		return dailyAccountBalanceService.search(dailyAccountBalance);
	}
	
	@PostMapping("/xml/{startDate}/{endDate}")
	public void exportToXml(@PathVariable("startDate")String startDateString,@PathVariable("endDate")String endDateString,@RequestBody BankAccount legalEntityAccount) throws JAXBException{
		
		String startDateChanged = startDateString; //+ ",00:00:00 AM";
		String endDateChanged = endDateString; // + ",00:00:00 AM";

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		Date startDate;
		Date endDate;
		try {
			startDate = formatter.parse(startDateChanged);
			endDate = formatter.parse(endDateChanged);
			exportXml(startDate,endDate,legalEntityAccount);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void  exportXml(Date startDate,Date endDate, BankAccount legalEntityAccount)  throws JAXBException{
		
		ArrayList<DailyAccountBalance> dailyAccountBalances = (ArrayList<DailyAccountBalance>) dailyAccountBalanceService.findBalances(legalEntityAccount, startDate, endDate);
		AccountStatement accountStatement = new AccountStatement(startDate,endDate,legalEntityAccount.getAccountNumber());
		//		Balances balances = new Balances();
		if(dailyAccountBalances.size()>0) {
				DailyAccountBalance firstBalance=dailyAccountBalances.get(0);
				DailyAccountBalance lastBalance=dailyAccountBalances.get(0);

			
			for(DailyAccountBalance d : dailyAccountBalances){
//				ArrayList<AnalyticsOfStatements> analyticsOfStatements = analyticsOfStatementsService.findByDateAndAccount(legalEntityAccount,d.getTrafficDate());
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
				for(AnalyticsOfStatements analyticsOfStatement : d.getAnalyticsOfStatements()){
					if(analyticsOfStatement.getDebtorAccount().equals(legalEntityAccount.getAccountNumber())) {
						accountStatement.setCountOfTrafficToBurden(accountStatement.getCountOfTrafficToBurden()+1);
					}
					else {
						accountStatement.setCountOfTrafficToBenefit(accountStatement.getCountOfTrafficToBenefit()+1);
					}
				}
				
			}
			
			accountStatement.setStartAccountState(firstBalance.getPreviousState());
			accountStatement.setStateAtTheEndOfPeriod(lastBalance.getNewState());

		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		File file=(this.rootLocation.resolve("account("+accountStatement.getAccountNumber()+")-balans-from-"+df.format(startDate)+"-to-"+df.format(endDate)+".xml")).toFile();
		JAXBContext jaxbContext = JAXBContext.newInstance(AccountStatement.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(accountStatement, file);
		jaxbMarshaller.marshal(accountStatement, System.out);
	}
	
	@GetMapping("/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		File dir = rootLocation.toFile();
		File[] files = dir.listFiles();
//		List<String> listOfFiles= Arrays.asList(files);
		List<String> listOfFiles= new ArrayList<String>();
		for(int i=0;i<files.length;i++) {
			listOfFiles.add(files[0].getName());
		}
		
		List<String> fileNames = listOfFiles.stream().map(fileName -> MvcUriComponentsBuilder
				.fromMethodName(DailyAccountBalanceController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());
				
		return ResponseEntity.ok().body(fileNames);
	}
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFileWithRoot(rootLocation,filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
}

	