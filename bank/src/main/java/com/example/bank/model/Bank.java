package com.example.bank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.example.bank.model.ExchangeRateList;
import com.example.bank.model.InterbankTransfer;
import com.example.bank.model.BankAccount;

@Entity
@Table(name = "bank")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@XmlElement
	private Long id;

	@Column(unique = true, columnDefinition = "CHAR(3)")
//	@NotBlank
	@XmlElement
	private String bankCode;

	@Column(unique = true, columnDefinition = "CHAR(10)")
//	@NotBlank
	@XmlElement
	private String pib;

	@Column(length = 120)
//	@NotBlank
	@XmlElement
	private String name;

	@Column(length = 120)
//	@NotBlank
	@XmlElement
	private String address;

	@Column(length = 128)
//	@Email
	@XmlElement
	private String email;

	@Column(length = 128)
	@XmlElement
	private String web;
	
	@Column(length = 20)
	@XmlElement
	private String phone;
	
	@Column(length = 20)
	@XmlElement
	private String fax;
	
	@Column
	@NotNull
	@XmlElement
	private Boolean bank;
	
	@Column(length = 8)
//	@NotBlank
	@XmlElement
	private String swift;
	
	@Column(length = 18)
//	@NotBlank
	@XmlElement
	private String racun;
	
	@JsonIgnore
	@OneToMany(mappedBy = "commercialBankRate", cascade = CascadeType.ALL)
	@XmlTransient
	private List<ExchangeRateList> exchangeRateLists;

	
	@JsonIgnore
	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	@XmlTransient
	private List<BankAccount> legalEntityAccount;	

	
	@JsonIgnore
	@OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
	@XmlTransient
	private List<InterbankTransfer> interbankTransfers;
	public Long getId() {
		return id;
	}

	
	public String getSwift() {
		return swift;
	}


	public String getRacun() {
		return racun;
	}


	public void setRacun(String racun) {
		this.racun = racun;
	}


	public void setSwift(String swift) {
		this.swift = swift;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}


	public List<ExchangeRateList> getExchangeRateLists() {
		return exchangeRateLists;
	}

	public void setExchangeRateLists(List<ExchangeRateList> exchangeRateLists) {
		this.exchangeRateLists = exchangeRateLists;
	}

	public List<BankAccount> getLegalEntityAccount() {
		return legalEntityAccount;
	}

	public void setLegalEntityAccount(List<BankAccount> legalEntityAccount) {
		this.legalEntityAccount = legalEntityAccount;
	}

	public List<InterbankTransfer> getInterbankTransfers() {
		return interbankTransfers;
	}

	public void setInterbankTransfers(List<InterbankTransfer> interbankTransfers) {
		this.interbankTransfers = interbankTransfers;
	}

	public Boolean getBank() {
		return bank;
	}

	public void setBank(Boolean bank) {
		this.bank = bank;
	}

	

	

	public Bank(Long id, String bankCode, String pib, String name, String address, String email, String web,
			String phone, String fax, @NotNull Boolean bank, String swift, String racun,
			List<ExchangeRateList> exchangeRateLists, List<BankAccount> legalEntityAccount,
			List<InterbankTransfer> interbankTransfers) {
		super();
		this.id = id;
		this.bankCode = bankCode;
		this.pib = pib;
		this.name = name;
		this.address = address;
		this.email = email;
		this.web = web;
		this.phone = phone;
		this.fax = fax;
		this.bank = bank;
		this.swift = swift;
		this.racun = racun;
		this.exchangeRateLists = exchangeRateLists;
		this.legalEntityAccount = legalEntityAccount;
		this.interbankTransfers = interbankTransfers;
	}


	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	


}
