package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Img {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private byte[] logo;
	
	private String fileName;
	
	@OneToOne(mappedBy="adress")
	private Projet projett;
	

	public Long getId() {
		return id;
	}

	public Projet getProjett() {
		return projett;
	}

	public void setProjett(Projet projett) {
		this.projett = projett;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getLogo() {
		return logo;
	}

	public Img() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Img(Long id, byte[] logo, String fileName) {
		super();
		this.id = id;
		this.logo = logo;
		this.fileName = fileName;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
