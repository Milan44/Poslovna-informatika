package com.example.bank.DTO;


public class BankAccountDTO {
	
	private String accountNumber;

	private String dateOfOpening;

	private Boolean valid;
	
	private double money;
	
	private Long clientID;

	private Long bankID;

	private Long currencyID;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDateOfOpening() {
		return dateOfOpening;
	}

	public void setDateOfOpening(String dateOfOpening) {
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

	
	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public Long getBankID() {
		return bankID;
	}

	public void setBankID(Long bankID) {
		this.bankID = bankID;
	}

	public Long getCurrencyID() {
		return currencyID;
	}

	public void setCurrencyID(Long currencyID) {
		this.currencyID = currencyID;
	}

	public BankAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccountDTO(String accountNumber, String dateOfOpening, Boolean valid, double money, Long clientID,
			Long bankID, Long currencyID) {
		super();
		this.accountNumber = accountNumber;
		this.dateOfOpening = dateOfOpening;
		this.valid = valid;
		this.money = money;
		this.clientID = clientID;
		this.bankID = bankID;
		this.currencyID = currencyID;
	}
	
	
	

}
