package com.bezkoder.springjwt.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(	name = "projets_finances")
public class Projets_Finances implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double montant;
	
	private Date date_financement;
	
	//investisseur
		@ManyToOne
		private User investisseur;
		
		@ManyToOne
		private Projet projet;
	


	public Projet getProjet() {
			return projet;
		}


		public void setProjet(Projet projet) {
			this.projet = projet;
		}


	public Projets_Finances(Long id, double montant, Date date_financement, User investisseur
			//, Projet projet
			) {
			super();
			this.id = id;
			this.montant = montant;
			this.date_financement = date_financement;
			this.investisseur = investisseur;
			//this.projet = projet;
		}


	public Projets_Finances() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User getInvestisseur() {
		return investisseur;
	}


	public void setInvestisseur(User investisseur) {
		this.investisseur = investisseur;
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public Date getDate_financement() {
		return date_financement;
	}


	public void setDate_financement(Date date_financement) {
		this.date_financement = date_financement;
	}


	


	
	
   
	
	
	

}
