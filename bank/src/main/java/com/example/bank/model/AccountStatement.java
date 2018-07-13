package com.example.bank.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.bank.model.AnalyticsOfStatements;;



@Entity
@Table(name = "accountStatement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "accountStatement")
public class AccountStatement {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@XmlElement
	private Date fromDate;
	
	@XmlElement
	private Date toDate;
	
	@XmlElement
	private Float startAccountState;
	
	@XmlElement
	private Float trafficToBenefit;
	
	@XmlElement
	private Float trafficToTheBurden; //promet na teret
	
	@XmlElement
	private Float stateAtTheEndOfPeriod;
	
	@OneToMany
	@XmlElement
	private List<AnalyticsOfStatements>statements;
	
	@XmlElement
	private String accountNumber;

	@XmlElement
	private int countOfTrafficToBenefit;
	
	@XmlElement
	private int countOfTrafficToBurden;
	
	@XmlElement
	private int numberOfSection;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<AnalyticsOfStatements> getStatements() {
		return statements;
	}


	public void setStatements(List<AnalyticsOfStatements> statements) {
		this.statements = statements;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public Float getStartAccountState() {
		return startAccountState;
	}


	public void setStartAccountState(Float startAccountState) {
		this.startAccountState = startAccountState;
	}


	public Float getTrafficToBenefit() {
		return trafficToBenefit;
	}


	public void setTrafficToBenefit(Float trafficToBenefit) {
		this.trafficToBenefit = trafficToBenefit;
	}


	public Float getTrafficToTheBurden() {
		return trafficToTheBurden;
	}


	public void setTrafficToTheBurden(Float trafficToTheBurden) {
		this.trafficToTheBurden = trafficToTheBurden;
	}


	public Float getStateAtTheEndOfPeriod() {
		return stateAtTheEndOfPeriod;
	}


	public void setStateAtTheEndOfPeriod(Float stateAtTheEndOfPeriod) {
		this.stateAtTheEndOfPeriod = stateAtTheEndOfPeriod;
	}


	public AccountStatement(Long id, Date fromDate, Date toDate, Float startAccountState, Float trafficToBenefit,
			Float trafficToTheBurden, Float stateAtTheEndOfPeriod, List<AnalyticsOfStatements> statements) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.startAccountState = startAccountState;
		this.trafficToBenefit = trafficToBenefit;
		this.trafficToTheBurden = trafficToTheBurden;
		this.stateAtTheEndOfPeriod = stateAtTheEndOfPeriod;
		this.statements = statements;
	}


	public AccountStatement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
