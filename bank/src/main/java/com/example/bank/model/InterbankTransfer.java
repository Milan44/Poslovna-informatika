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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.example.bank.model.AddaptDate;
import com.example.bank.model.Bank;
import com.example.bank.model.ItemTransfer;

/**
 * medjubankarski prenos
 */

@Entity
@Table(name = "interbankTransfer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "interbankTransfer")
public class InterbankTransfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@XmlElement
	private Long idMessage;

	@Column(columnDefinition = "CHAR(5)")
//	@NotBlank
	@XmlElement
	private String typeOfMessage;

	@Column
	@NotNull
//	@XmlJavaTypeAdapter(AddaptDate.class)
	@XmlElement
	private Date date;

	@Column
	@XmlElement
	private Float sum;
	
	@ManyToOne
	@XmlElement
	private Bank senderBank;

	@ManyToOne
	@XmlElement
	private Bank bank;
	
	private Boolean processed;
	
	@JsonIgnore
	@OneToMany(mappedBy = "interbankTransfer",cascade = CascadeType.ALL)
	@XmlElement
	private List<ItemTransfer> itemTransfers; 
	
	
	public InterbankTransfer() {
		super();
	}

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	public String getTypeOfMessage() {
		return typeOfMessage;
	}

	public void setTypeOfMessage(String typeOfMessage) {
		this.typeOfMessage = typeOfMessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getSum() {
		return sum;
	}

	public void setSum(Float sum) {
		this.sum = sum;
	}

	public Bank getSenderBank() {
		return senderBank;
	}

	public void setSenderBank(Bank senderBank) {
		this.senderBank = senderBank;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<ItemTransfer> getItemTransfers() {
		return itemTransfers;
	}

	public void setItemTransfers(List<ItemTransfer> itemTransfers) {
		this.itemTransfers = itemTransfers;
	}

	public Boolean getProcessed() {
		return processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	public InterbankTransfer(Long idMessage, String typeOfMessage, @NotNull Date date, Float sum, Bank senderBank,
			Bank bank, Boolean processed, List<ItemTransfer> itemTransfers) {
		super();
		this.idMessage = idMessage;
		this.typeOfMessage = typeOfMessage;
		this.date = date;
		this.sum = sum;
		this.senderBank = senderBank;
		this.bank = bank;
		this.processed = processed;
		this.itemTransfers = itemTransfers;
	}
	
	

}
