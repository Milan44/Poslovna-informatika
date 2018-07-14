package com.example.bank.DTO;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;

import com.example.bank.model.Place;

public class ClientDTO {
	
	private Long id;
	
	private String address;
	
	private String phone;
	
	private String fax;
	
	private String email;
	
	private String addressForStatements;
	
	private Boolean emailStatements;
	
	private String name;
	
	private String jmbg;
	
	private String typeOfClient;

	private Long residenceID;
	
	private String pib;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressForStatements() {
		return addressForStatements;
	}

	public void setAddressForStatements(String addressForStatements) {
		this.addressForStatements = addressForStatements;
	}

	public Boolean getEmailStatements() {
		return emailStatements;
	}

	public void setEmailStatements(Boolean emailStatements) {
		this.emailStatements = emailStatements;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getTypeOfClient() {
		return typeOfClient;
	}

	public void setTypeOfClient(String typeOfClient) {
		this.typeOfClient = typeOfClient;
	}

	public Long getResidenceID() {
		return residenceID;
	}

	public void setResidenceID(Long residenceID) {
		this.residenceID = residenceID;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public ClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientDTO(String address, String phone, String fax, String email, String addressForStatements,
			Boolean emailStatements, String name, String jmbg, String typeOfClient, Long residenceID, String pib) {
		super();
		this.address = address;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.addressForStatements = addressForStatements;
		this.emailStatements = emailStatements;
		this.name = name;
		this.jmbg = jmbg;
		this.typeOfClient = typeOfClient;
		this.residenceID = residenceID;
		this.pib = pib;
	}

	
	
	

}
