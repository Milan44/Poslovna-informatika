package com.example.bank.DTO;

import com.example.bank.model.Country;

public class CurrencyDTO {
	
	private Long id;

	private String official_code;

	private String name;

	private Boolean domicilna; // sta ovde treba da pise?

	private Long countryID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOfficial_code() {
		return official_code;
	}

	public void setOfficial_code(String official_code) {
		this.official_code = official_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDomicilna() {
		return domicilna;
	}

	public void setDomicilna(Boolean domicilna) {
		this.domicilna = domicilna;
	}

	public Long getCountryID() {
		return countryID;
	}

	public void setCountryID(Long countryID) {
		this.countryID = countryID;
	}

	public CurrencyDTO(Long id, String official_code, String name, Boolean domicilna, Long countryID) {
		super();
		this.id = id;
		this.official_code = official_code;
		this.name = name;
		this.domicilna = domicilna;
		this.countryID = countryID;
	}

	public CurrencyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
