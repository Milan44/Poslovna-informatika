package com.example.bank.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.example.bank.model.Bank;
import com.example.bank.model.Client;
import com.example.bank.model.Currency;
import com.example.bank.model.DailyAccountBalance;
import com.example.bank.model.Suspension;

@Entity
@Table(name = "bankAccount")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BankAccount")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;

	@Column(unique = true, columnDefinition = "CHAR(18)")
//	@NotBlank
	@XmlElement
	private String accountNumber;

	@XmlElement
	private Date dateOfOpening;
	
	@XmlElement
	private Boolean valid;
	
	@XmlElement
	private double money;

	@ManyToOne
	@XmlElement
	private Client client;

	@ManyToOne
	@XmlElement
	private Bank bank;

	@ManyToOne
	@XmlElement
	private Currency currency;

	@JsonIgnore
	@OneToMany(mappedBy = "legalEntityAccount", cascade = CascadeType.ALL)
	@XmlTransient
	private List<Suspension> suspensions;
	
	@JsonIgnore
	@OneToMany(mappedBy = "legalEntityAccount", cascade = CascadeType.ALL)
	@XmlTransient
	private List<DailyAccountBalance> dailyAccountBalances;

	
	
	public BankAccount() {
		super();
	}

	

	public BankAccount(Long id, String accountNumber, Date dateOfOpening, Boolean valid, double money, Client client,
			Bank bank, Currency currency, List<Suspension> suspensions,
			List<DailyAccountBalance> dailyAccountBalances) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.dateOfOpening = dateOfOpening;
		this.valid = valid;
		this.money = money;
		this.client = client;
		this.bank = bank;
		this.currency = currency;
		this.suspensions = suspensions;
		this.dailyAccountBalances = dailyAccountBalances;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public Date getDateOfOpening() {
		return dateOfOpening;
	}


	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}


	public Boolean getValid() {
		return valid;
	}


	public void setValid(Boolean valid) {
		this.valid = valid;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public List<Suspension> getSuspensions() {
		return suspensions;
	}

	public void setSuspensions(List<Suspension> suspensions) {
		this.suspensions = suspensions;
	}


	public List<DailyAccountBalance> getDailyAccountBalances() {
		return dailyAccountBalances;
	}


	public void setDailyAccountBalances(List<DailyAccountBalance> dailyAccountBalances) {
		this.dailyAccountBalances = dailyAccountBalances;
	}


	
	

}
