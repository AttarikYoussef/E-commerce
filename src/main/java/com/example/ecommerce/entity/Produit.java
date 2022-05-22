package com.example.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue
	private Long idProduit;
	private String marqueProduit;
	private String nomProduit;
	private String descProduit;
	private Float prixProduit;
	private String photo;
	
	
	
	

}
