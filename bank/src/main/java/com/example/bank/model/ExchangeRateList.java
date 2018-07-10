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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.example.bank.model.Bank;
import com.example.bank.model.CurrencyRate;

/**
 * kursna lista
 */
@Entity
@Table(name = "exchangeRateList")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ExchangeRateList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "exchange_rate_list_id")
	@XmlElement
	private Long id;

	@Column
	@NotNull
	@XmlElement
	private Date date;

	@Column(unique = true)
	@XmlElement
	private int numberOfExchangeRateList; // broj kursne liste

	@Column
	@XmlElement
	private Date appliedBy; // primenjuje se od

	@JsonIgnore
	@OneToMany(mappedBy = "currencyInList", cascade = CascadeType.ALL)
	@XmlElement
	private List<CurrencyRate> currencyRates;

	@ManyToOne
	@XmlElement
	private Bank commercialBankRate; // kurs poslovne banke

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNumberOfExchangeRateList() {
		return numberOfExchangeRateList;
	}

	public void setNumberOfExchangeRateList(int numberOfExchangeRateList) {
		this.numberOfExchangeRateList = numberOfExchangeRateList;
	}

	public Date getAppliedBy() {
		return appliedBy;
	}

	public void setAppliedBy(Date appliedBy) {
		this.appliedBy = appliedBy;
	}

	public Bank getCommercialBankRate() {
		return commercialBankRate;
	}

	public void setCommercialBankRate(Bank commercialBankRate) {
		this.commercialBankRate = commercialBankRate;
	}

	public List<CurrencyRate> getCurrencyRates() {
		return currencyRates;
	}

	public void setCurrencyRates(List<CurrencyRate> currencyRates) {
		this.currencyRates = currencyRates;
	}

	public ExchangeRateList(Long id, @NotNull Date date, int numberOfExchangeRateList, Date appliedBy,
			List<CurrencyRate> currencyRates, Bank commercialBankRate) {
		super();
		this.id = id;
		this.date = date;
		this.numberOfExchangeRateList = numberOfExchangeRateList;
		this.appliedBy = appliedBy;
		this.currencyRates = currencyRates;
		this.commercialBankRate = commercialBankRate;
	}

	public ExchangeRateList() {
		super();
		// TODO Auto-generated constructor stub
	}

}
