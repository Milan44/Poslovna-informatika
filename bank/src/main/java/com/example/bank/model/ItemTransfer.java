package com.example.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.model.InterbankTransfer;

/**
 * stavke prenosa
 */

@Entity
@Table(name = "itemTransfer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "itemTransfer")
public class ItemTransfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@XmlElement
	private Long id;
	
	@ManyToOne
	@XmlElement
	private AnalyticsOfStatements analyticsOfStatements;
	
	@ManyToOne
	@XmlTransient
	private InterbankTransfer interbankTransfer;

	public ItemTransfer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AnalyticsOfStatements getAnalyticsOfStatements() {
		return analyticsOfStatements;
	}

	public void setAnalyticsOfStatements(AnalyticsOfStatements analyticsOfStatements) {
		this.analyticsOfStatements = analyticsOfStatements;
	}

	public InterbankTransfer getInterbankTransfer() {
		return interbankTransfer;
	}

	public void setInterbankTransfer(InterbankTransfer interbankTransfer) {
		this.interbankTransfer = interbankTransfer;
	}

	public ItemTransfer(Long id, AnalyticsOfStatements analyticsOfStatements, InterbankTransfer interbankTransfer) {
		super();
		this.id = id;
		this.analyticsOfStatements = analyticsOfStatements;
		this.interbankTransfer = interbankTransfer;
	}
	
}
