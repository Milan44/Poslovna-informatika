package com.example.bank.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import com.example.bank.controller.AddaptDate;

@Entity
@Table(name = "clearingItem")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "clearingItem")
public class ClearingItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@XmlElement
	private Long clearingItemId;
	
	public Long getClearingItemId() {
		return clearingItemId;
	}

	@Column(length = 50)
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
	
	@Column(length = 15, precision = 2)
	@XmlElement
	private Float iznos;
	
	@Column(length = 3)
	@XmlElement
	private String sifraValute;
	
	

	

	public ClearingItem(Long clearingItemId, Long itemNumber, String debtor_originator, String purposeOfPayment,
			String creditor_recipient, @NotNull Date dateOfReceipt, @NotNull Date currencyDate, String debtorAccount,
			@Max(99) Integer modelAssigments, String referenceNumberAssigments, String accountCreditor,
			@Max(99) Integer modelApproval, String referenceNumberCreditor, Float iznos, String sifraValute) {
		super();
		this.clearingItemId = clearingItemId;
		this.itemNumber = itemNumber;
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
		this.iznos = iznos;
		this.sifraValute = sifraValute;
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

	public Float getIznos() {
		return iznos;
	}

	public void setIznos(Float iznos) {
		this.iznos = iznos;
	}

	public String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(String sifraPlacanja) {
		this.sifraValute = sifraPlacanja;
	}


	public Long getItemNumber() {
		return itemNumber;
	}

	public ClearingItem() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	

}
