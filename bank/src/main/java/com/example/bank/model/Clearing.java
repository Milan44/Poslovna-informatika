package com.example.bank.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.JoinColumn;
@Entity
@Table(name = "clearing")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "clearing")
public class Clearing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@XmlElement
	private Long clearingId;
	
	@Column(length = 50)
	@XmlElement
	private String porukaID;
	
	@Column(length = 8)
	@XmlElement
	private String duznikSWIFT;
	
	@Column(length = 18)
	@XmlElement
	private String duznikObracunskiRacun;
	
	@Column(length = 8)
	@XmlElement
	private String poverilacSWIFT;
	
	@Column(length = 18)
	@XmlElement
	private String poveriocObracunskiRacun;
	
	@Column(precision=15, scale=2)
	@XmlElement
	private double ukupanIznos;
	
	@Column(length = 3)
	@XmlElement
	private String sifraValute;
	
	@Column
	@XmlElement
	private Date datumValute;
	
	@Column
	@XmlElement
	private Date datum;
	
	@Column
	@XmlElement
	private Boolean exportovan;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "clearing_items", joinColumns = @JoinColumn(name = "clearingId"), inverseJoinColumns = @JoinColumn(name = "clearingItemId"))
    private List<ClearingItem> nalozi;
	
	
	public Boolean getExportovan() {
		return exportovan;
	}

	public void setExportovan(Boolean exportovan) {
		this.exportovan = exportovan;
	}

	public String getPorukaID() {
		return porukaID;
	}

	public void setPorukaID(String porukaID) {
		this.porukaID = porukaID;
	}

	public String getDuznikSWIFT() {
		return duznikSWIFT;
	}

	

	public void setDuznikSWIFT(String duznikSWIFT) {
		this.duznikSWIFT = duznikSWIFT;
	}

	public String getDuznikObracunskiRacun() {
		return duznikObracunskiRacun;
	}

	public void setDuznikObracunskiRacun(String duznikObracunskiRacun) {
		this.duznikObracunskiRacun = duznikObracunskiRacun;
	}

	public String getPoverilacSWIFT() {
		return poverilacSWIFT;
	}

	public void setPoverilacSWIFT(String poverilacSWIFT) {
		this.poverilacSWIFT = poverilacSWIFT;
	}

	public String getPoveriocObracunskiRacun() {
		return poveriocObracunskiRacun;
	}

	public void setPoveriocObracunskiRacun(String poveriocObracunskiRacun) {
		this.poveriocObracunskiRacun = poveriocObracunskiRacun;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public List<ClearingItem> getNalozi() {
		return nalozi;
	}

	public void setNalozi(List<ClearingItem> nalozi) {
		this.nalozi = nalozi;
	}

	
	

	public Clearing(Long clearingId, String porukaID, String duznikSWIFT, String duznikObracunskiRacun,
			String poverilacSWIFT, String poveriocObracunskiRacun, double ukupanIznos, String sifraValute,
			Date datumValute, Date datum, Boolean exportovan, List<ClearingItem> nalozi) {
		super();
		this.clearingId = clearingId;
		this.porukaID = porukaID;
		this.duznikSWIFT = duznikSWIFT;
		this.duznikObracunskiRacun = duznikObracunskiRacun;
		this.poverilacSWIFT = poverilacSWIFT;
		this.poveriocObracunskiRacun = poveriocObracunskiRacun;
		this.ukupanIznos = ukupanIznos;
		this.sifraValute = sifraValute;
		this.datumValute = datumValute;
		this.datum = datum;
		this.exportovan = exportovan;
		this.nalozi = nalozi;
	}

	public Clearing() {
		super();
		this.nalozi = new ArrayList<>();
	}

	public Long getClearingId() {
		return clearingId;
	}
	
	
}
