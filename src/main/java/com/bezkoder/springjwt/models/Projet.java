package com.bezkoder.springjwt.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@Table(	name = "projets")
public class Projet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom_projet;
	
	private String pays;
	
	private String path_image;
	
	private double budget;
	
	private double solde;
	
	private Date date_ajout;

	private Date delai_projet;
	
	private String description_projet;
	
    private Boolean isCloture;
	
    private String status;

	@ManyToOne
	private User user;
	
	@ManyToOne
    private Categorie categorie;
	
	@OneToMany
	(mappedBy = "projet")
	@JsonIgnoreProperties("projet")
	private Collection<Projets_Finances> projets_finances;
	
	@OneToOne
	@JoinColumn(name="adress")
	private Img adress;
	
	

	public Img getAdress() {
		return adress;
	}

	public void setAdress(Img adress) {
		this.adress = adress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_projet() {
		return nom_projet;
	}

	public void setNom_projet(String nom_projet) {
		this.nom_projet = nom_projet;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	public Date getDate_ajout() {
		return date_ajout;
	}

	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}


	public Date getDelai_projet() {
		return delai_projet;
	}

	public void setDelai_projet(Date delai_projet) {
		this.delai_projet = delai_projet;
	}

	public String getDescription_projet() {
		return description_projet;
	}

	public void setDescription_projet(String description_projet) {
		this.description_projet = description_projet;
	}

	public Boolean getIsCloture() {
		return isCloture;
	}

	public void setIsCloture(Boolean isCloture) {
		this.isCloture = isCloture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public String getPath_image() {
		return path_image;
	}

	public void setPath_image(String path_image) {
		this.path_image = path_image;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	   
	
	public Projet(Long id, String nom_projet, String pays, String path_image, double budget, Date date_ajout,
			Date delai_projet, String description_projet, Boolean isCloture, String status, User user,
			Categorie categorie) {
		super();
		this.id = id;
		this.nom_projet = nom_projet;
		this.pays = pays;
		this.path_image = path_image;
		this.budget = budget;
		this.date_ajout = date_ajout;
		this.delai_projet = delai_projet;
		this.description_projet = description_projet;
		this.isCloture = isCloture;
		this.status = status;
		this.user = user;
		this.categorie = categorie;
		//this.projets_finances = projets_finances;
	}

	/*public Collection<Projets_Finances> getProjets_finances() {
		return projets_finances;
	}*/

	public void setProjets_finances(Collection<Projets_Finances> projets_finances) {
		this.projets_finances = projets_finances;
	}
	
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	

}
