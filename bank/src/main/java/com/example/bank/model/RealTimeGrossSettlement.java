package com.example.bank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "realTimeGrossSettlement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "realTimeGrossSettlement")
public class RealTimeGrossSettlement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@XmlElement
	private Long id;
	
	
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

	@Column(length = 255)
	@XmlElement
	private String duznik;
	
	@Column(length = 255)
	@XmlElement
	private String poverilac;
	
	@Column
	@XmlElement
	private Date datumNaloga;
	
	@Column
	@XmlElement
	private Date datumValute;
	
	@Column(length = 18)
	@XmlElement
	private String duznikRacun;
	
	@Column(length = 2)
	@XmlElement
	private Long modelZaduzenja;
	
	@Column(length = 20)
	@XmlElement
	private String pozivNaBrojZaduzenja;
	
	@Column(length = 18)
	@XmlElement
	private String poverlacRacun;
	
	@Column(length = 2)
	@XmlElement
	private Long modelOdobrenja;
	
	@Column(length = 20)
	@XmlElement
	private String pozivNaBrojOdobrenja;
	
	@Column(precision=15, scale=2)
	@XmlElement
	private double iznos;
	
	@Column(length = 3)
	@XmlElement
	private String sifraValute;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDuznik() {
		return duznik;
	}

	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}

	public String getPoverilac() {
		return poverilac;
	}

	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}

	public Date getDatumNaloga() {
		return datumNaloga;
	}

	public void setDatumNaloga(Date datumNaloga) {
		this.datumNaloga = datumNaloga;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public String getDuznikRacun() {
		return duznikRacun;
	}

	public void setDuznikRacun(String duznikRacun) {
		this.duznikRacun = duznikRacun;
	}

	public Long getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(Long modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivNaBrojZaduzenja() {
		return pozivNaBrojZaduzenja;
	}

	public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
	}

	public String getPoverlacRacun() {
		return poverlacRacun;
	}

	public void setPoverlacRacun(String poverlacRacun) {
		this.poverlacRacun = poverlacRacun;
	}

	public Long getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(Long modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public RealTimeGrossSettlement(Long id, String porukaID, String duznikSWIFT, String duznikObracunskiRacun,
			String poverilacSWIFT, String poveriocObracunskiRacun, String duznik, String poverilac, Date datumNaloga,
			Date datumValute, String duznikRacun, Long modelZaduzenja, String pozivNaBrojZaduzenja,
			String poverlacRacun, Long modelOdobrenja, String pozivNaBrojOdobrenja, double iznos, String sifraValute) {
		super();
		this.id = id;
		this.porukaID = porukaID;
		this.duznikSWIFT = duznikSWIFT;
		this.duznikObracunskiRacun = duznikObracunskiRacun;
		this.poverilacSWIFT = poverilacSWIFT;
		this.poveriocObracunskiRacun = poveriocObracunskiRacun;
		this.duznik = duznik;
		this.poverilac = poverilac;
		this.datumNaloga = datumNaloga;
		this.datumValute = datumValute;
		this.duznikRacun = duznikRacun;
		this.modelZaduzenja = modelZaduzenja;
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
		this.poverlacRacun = poverlacRacun;
		this.modelOdobrenja = modelOdobrenja;
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
		this.iznos = iznos;
		this.sifraValute = sifraValute;
	}

	public RealTimeGrossSettlement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
