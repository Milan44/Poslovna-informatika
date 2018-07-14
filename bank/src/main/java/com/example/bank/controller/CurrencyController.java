package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.DTO.CurrencyDTO;
import com.example.bank.model.BankAccount;
import com.example.bank.model.Country;
import com.example.bank.model.Currency;
import com.example.bank.repository.CountryRepository;
import com.example.bank.service.CountryService;
import com.example.bank.service.CurrencyService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/currencies")
public class CurrencyController {
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private CountryService countryService;
	
	
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Currency> getCurencies() {
		
		
		return currencyService.getAll();
		
	}
	
	
	@RequestMapping(
			value = "/registerCurrency",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean registerClient(@RequestBody CurrencyDTO currencyDTO) {
		
		try {
			Country country = countryService.getCountryById(currencyDTO.getCountryID());
			Currency currency = new Currency();
			currency.setCountry(country);
			currency.setDomicilna(currencyDTO.getDomicilna());
			currency.setName(currencyDTO.getName());
			currency.setOfficial_code(currencyDTO.getOfficial_code());
			
			currencyService.registerCurrency(currency);
			
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}	
		
	}
	
	
	@RequestMapping(
			value = "/updateCurrency",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateCurrency(@RequestBody CurrencyDTO currencyDTO) {
		
		try {
			Country country = countryService.getCountryById(currencyDTO.getCountryID());
			Currency currency = currencyService.getCurrencyById(currencyDTO.getId());
			currency.setId(currencyDTO.getId());
			currency.setCountry(country);
			currency.setDomicilna(currencyDTO.getDomicilna());
			currency.setName(currencyDTO.getName());
			currency.setOfficial_code(currencyDTO.getOfficial_code());
			
			currencyService.registerCurrency(currency);
			
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}	
		
	}
	
	
	@RequestMapping(
			value = "/deleteCurrency/{currencyID}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public  boolean deleteCurrency(@PathVariable("currencyID") Long currencyID){
		
			
		Currency currency = currencyService.getCurrencyById(currencyID);
		if(currency.getAccordingToCurrencyRate().isEmpty() && currency.getAnalyticsOfStatements().isEmpty()
				&& currency.getBaseCurrencyRate().isEmpty() && currency.getLegalEntityAccount().isEmpty()) {
			
			currencyService.deleteCurrency(currencyID);
			return true;
		}
		
		else 
			return false;
		
			
		
	}
	

}
