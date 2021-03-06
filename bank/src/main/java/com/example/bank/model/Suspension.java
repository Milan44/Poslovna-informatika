package com.example.bank.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.NotBlank;

import com.example.bank.model.BankAccount;

/**
 * ukidanje
 */
@Entity
@Table(name = "suspension")
public class Suspension {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	@NotNull
	private Date date;
	
	@Column(length = 20)
//	@NotBlank
	private String transferToAccount; //sredstva se prenose na racun

	
	@ManyToOne
	private BankAccount legalEntityAccount;
	
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

	public String getTransferToAccount() {
		return transferToAccount;
	}

	public void setTransferToAccount(String transferToAccount) {
		this.transferToAccount = transferToAccount;
	}

	public BankAccount getLegalEntityAccount() {
		return legalEntityAccount;
	}

	public void setLegalEntityAccount(BankAccount legalEntityAccount) {
		this.legalEntityAccount = legalEntityAccount;
	}

	public Suspension(Long id, @NotNull Date date, String transferToAccount, BankAccount legalEntityAccount) {
		super();
		this.id = id;
		this.date = date;
		this.transferToAccount = transferToAccount;
		this.legalEntityAccount = legalEntityAccount;
	}

	public Suspension() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
