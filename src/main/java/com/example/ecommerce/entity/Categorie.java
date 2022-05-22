package com.example.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {
	@Id
	@GeneratedValue
	private Long idCategorie;
	private String description;
	private int annee;
	
	public Categorie() {
		super();
	}

	public Categorie(String description, int annee) {
		super();
		this.description = description;
		this.annee=annee;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	
	
	
	
	
	
}
