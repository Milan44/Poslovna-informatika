package com.example.bank.model;

import java.sql.Date;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.example.bank.model.Currency;
import com.example.bank.model.DailyAccountBalance;
import com.example.bank.model.ItemTransfer;
import com.example.bank.model.PaymentType;
import com.example.bank.model.Place;
import com.example.bank.controller.AddaptDate;

/**
 * analitika izvoda
 */

@Entity
@Table(name = "analyticsOfStatements")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "analyticsOfStatements")
public class AnalyticsOfStatements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@XmlElement
	private Long itemNumber;
	
	@Column(length = 256)
	@XmlElement
	private String debtor_originator; //duznik-nalogodavac

	@Column(length = 256)
	@XmlElement
	private String purposeOfPayment; //svrha placanja
	
	@Column(length = 256)
	@XmlElement
	private String creditor_recipient; //poverilac-primalac
	
	@Column
	@NotNull
	@XmlJavaTypeAdapter(AddaptDate.class)
	@XmlElement
	private Date dateOfReceipt; //datum prijema
	
	@Column
	@NotNull
	@XmlJavaTypeAdapter(AddaptDate.class)
	@XmlElement
	private Date currencyDate; //datum valute
	
	
	@Column(length = 18)
	@XmlElement
	private String debtorAccount; //racun duznika
	
	@Column
	@Max(value = 99)
	@XmlElement
	private Integer modelAssigments; //model zaduzenja
	
	@Column(length = 20)
	@XmlElement
	private String referenceNumberAssigments; //poziv na broj zaduzenja
	
	@Column(length = 18)
	@XmlElement
	private String accountCreditor; //racun poverioca
	
	@Column
	@Max(value = 99)
	@XmlElement
	private Integer modelApproval; //model odobrenja
	
	@Column(length = 20)
	@XmlElement
	private String referenceNumberCreditor; //poziv na broj odobrenja
	
	@Column
	@NotNull
	@XmlElement
	private Boolean emergency;
	
	@Column(length = 15, precision = 2)
	@XmlElement
	private Float sum;
	
	@Column
	@Max(value = 1)
	@XmlElement
	private Integer typeOfMistake; 
	
	@Column(length = 1)
	@XmlElement
	private String status;
	
	@ManyToOne
	 @XmlElement
	 private DailyAccountBalance dailyAccountBalance;
//	
//	@ManyToOne
//	@XmlTransient
//	private DailyAccountBalance dailyAccountBalance;
	
	// Analitika izvoda banke
	
	@ManyToOne
	@XmlElement
	private PaymentType paymentType;	// tip placanja
	
	@ManyToOne
	@XmlElement
	private Currency paymentCurrency;	// valuta placanja
	
	@JsonIgnore
	@OneToMany
	@XmlElement
	private List<ItemTransfer> itemTransfer;
	

	@ManyToOne
	@XmlElement
	private Place place;
	
	public AnalyticsOfStatements() {
		super();
	}

	public Long getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getDebtor_originator() {
		return debtor_originator;
	}

	public void setDebtor_originator(String debtor_originator) {
		this.debtor_originator = debtor_originator;
	}

	public String getPurposeOfPayment() {
		return purposeOfPayment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purposeOfPayment = purposeOfPayment;
	}

	public String getCreditor_recipient() {
		return creditor_recipient;
	}

	public void setCreditor_recipient(String creditor_recipient) {
		this.creditor_recipient = creditor_recipient;
	}

	public Date getDateOfReceipt() {
		return dateOfReceipt;
	}

	public void setDateOfReceipt(Date dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}

	public Date getCurrencyDate() {
		return currencyDate;
	}

	public void setCurrencyDate(Date currencyDate) {
		this.currencyDate = currencyDate;
	}

	public String getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(String debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public Integer getModelAssigments() {
		return modelAssigments;
	}

	public void setModelAssigments(Integer modelAssigments) {
		this.modelAssigments = modelAssigments;
	}

	public String getReferenceNumberAssigments() {
		return referenceNumberAssigments;
	}

	public void setReferenceNumberAssigments(String referenceNumberAssigments) {
		this.referenceNumberAssigments = referenceNumberAssigments;
	}

	public String getAccountCreditor() {
		return accountCreditor;
	}

	public void setAccountCreditor(String accountCreditor) {
		this.accountCreditor = accountCreditor;
	}

	public Integer getModelApproval() {
		return modelApproval;
	}

	public void setModelApproval(Integer modelApproval) {
		this.modelApproval = modelApproval;
	}

	public String getReferenceNumberCreditor() {
		return referenceNumberCreditor;
	}

	public void setReferenceNumberCreditor(String referenceNumberCreditor) {
		this.referenceNumberCreditor = referenceNumberCreditor;
	}

	public Boolean isEmergency() {
		return emergency;
	}

	public void setEmergency(Boolean emergency) {
		this.emergency = emergency;
	}

	public Float getSum() {
		return sum;
	}

	public void setSum(Float sum) {
		this.sum = sum;
	}

	public Integer getTypeOfMistake() {
		return typeOfMistake;
	}

	public void setTypeOfMistake(Integer typeOfMistake) {
		this.typeOfMistake = typeOfMistake;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DailyAccountBalance getDailyAccountBalance() {
		return dailyAccountBalance;
	}

	public void setDailyAccountBalance(DailyAccountBalance dailyAccountBalance) {
		this.dailyAccountBalance = dailyAccountBalance;
	}



	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Currency getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(Currency paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<ItemTransfer> getItemTransfer() {
		return itemTransfer;
	}

	public void setItemTransfer(List<ItemTransfer> itemTransfer) {
		this.itemTransfer = itemTransfer;
	}

	public Boolean getEmergency() {
		return emergency;
	}

	public AnalyticsOfStatements(String debtor_originator, String purposeOfPayment,
			String creditor_recipient, @NotNull Date dateOfReceipt, @NotNull Date currencyDate, String debtorAccount,
			@Max(99) Integer modelAssigments, String referenceNumberAssigments, String accountCreditor,
			@Max(99) Integer modelApproval, String referenceNumberCreditor, @NotNull Boolean emergency, Float sum,
			@Max(1) Integer typeOfMistake, String status, DailyAccountBalance dailyAccountBalance,
			PaymentType paymentType, Currency paymentCurrency, List<ItemTransfer> itemTransfer, Place place) {
		super();
		this.debtor_originator = debtor_originator;
		this.purposeOfPayment = purposeOfPayment;
		this.creditor_recipient = creditor_recipient;
		this.dateOfReceipt = dateOfReceipt;
		this.currencyDate = currencyDate;
		this.debtorAccount = debtorAccount;
		this.modelAssigments = modelAssigments;
		this.referenceNumberAssigments = referenceNumberAssigments;
		this.accountCreditor = accountCreditor;
		this.modelApproval = modelApproval;
		this.referenceNumberCreditor = referenceNumberCreditor;
		this.emergency = emergency;
		this.sum = sum;
		this.typeOfMistake = typeOfMistake;
		this.status = status;
		this.dailyAccountBalance = dailyAccountBalance;
		this.paymentType = paymentType;
		this.paymentCurrency = paymentCurrency;
		this.itemTransfer = itemTransfer;
		this.place = place;
	}
	public AnalyticsOfStatements(AnalyticsOfStatements analyticOfStatements) {
		super();
		this.debtor_originator = analyticOfStatements.debtor_originator;
		this.purposeOfPayment = analyticOfStatements.purposeOfPayment;
		this.creditor_recipient = analyticOfStatements.creditor_recipient;
		this.dateOfReceipt = analyticOfStatements.dateOfReceipt;
		this.currencyDate = analyticOfStatements.currencyDate;
		this.debtorAccount = analyticOfStatements.debtorAccount;
		this.modelAssigments = analyticOfStatements.modelAssigments;
		this.referenceNumberAssigments = analyticOfStatements.referenceNumberAssigments;
		this.accountCreditor = analyticOfStatements.accountCreditor;
		this.modelApproval = analyticOfStatements.modelApproval;
		this.referenceNumberCreditor = analyticOfStatements.referenceNumberCreditor;
		this.emergency = analyticOfStatements.emergency;
		this.sum = analyticOfStatements.sum;
		this.typeOfMistake = analyticOfStatements.typeOfMistake;
		this.status = analyticOfStatements.status;
		this.dailyAccountBalance = analyticOfStatements.dailyAccountBalance;
		this.paymentType = analyticOfStatements.paymentType;
		this.paymentCurrency = analyticOfStatements.paymentCurrency;
		this.itemTransfer = analyticOfStatements.itemTransfer;
		this.place = analyticOfStatements.place;
	}
}
