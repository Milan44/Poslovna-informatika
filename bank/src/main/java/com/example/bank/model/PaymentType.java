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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.example.bank.model.AnalyticsOfStatements;

/**
 * vrste placanja
 */

@Entity
@Table(name = "paymentType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "paymentType")
public class PaymentType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;
	// treba promeniti u number, ali ne znam koji tip tu da koristimo
	@Column(unique = true)
	@XmlElement
	private String code;

	@Column(length = 120)
//	@NotBlank
	@XmlElement
	private String nameOfPaymentType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "paymentType", cascade = CascadeType.ALL)
	@XmlTransient
	private List<AnalyticsOfStatements> analyticsOfStatements;

	public PaymentType() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameOfPaymentType() {
		return nameOfPaymentType;
	}

	public void setNameOfPaymentType(String nameOfPaymentType) {
		this.nameOfPaymentType = nameOfPaymentType;
	}

	public List<AnalyticsOfStatements> getAnalyticsOfStatements() {
		return analyticsOfStatements;
	}

	public void setAnalyticsOfStatements(List<AnalyticsOfStatements> analyticsOfStatements) {
		this.analyticsOfStatements = analyticsOfStatements;
	}

	public PaymentType(Long id, String code, String nameOfPaymentType,
			List<AnalyticsOfStatements> analyticsOfStatements) {
		super();
		this.id = id;
		this.code = code;
		this.nameOfPaymentType = nameOfPaymentType;
		this.analyticsOfStatements = analyticsOfStatements;
	}

	
}
