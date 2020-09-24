package com.bezkoder.springjwt.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Categorie")
public class Categorie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
   /* @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Id
    private String nom;

  
    
    @OneToMany
    (mappedBy="categorie")
  @JsonIgnoreProperties("categorie")
    private Collection<Projet> projets;



/*	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}*/



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Collection<Projet> getProjets() {
		return projets;
	}



	public void setProjets(Collection<Projet> projets) {
		this.projets = projets;
	}



	public Categorie(
			//Long id,
			String nom) {
		super();
		//this.id = id;
		this.nom = nom;
		//this.projets = projets;
	}



	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
