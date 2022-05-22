package com.example.ecommerce.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entity.Categorie;
import com.example.ecommerce.repository.CategorieRepo;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CategorieController {
	@Autowired
	CategorieRepo categorieRepo;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Categorie>> getAllCategories(){
		System.out.println("Je suis la");
		try {
			List<Categorie> categories = new ArrayList<Categorie>();
			categorieRepo.findAll().forEach(categories::add);
			if(categories.isEmpty()) {
				System.out.println("ta haja makayna");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categories,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie){
		try {
			Categorie cas_de_test = categorieRepo.findByDescription(categorie.getDescription());
			if(cas_de_test!=null) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				Categorie _categorie = categorieRepo
						.save(new Categorie(categorie.getDescription(), categorie.getAnnee()));
				return new ResponseEntity<Categorie>(_categorie,HttpStatus.CREATED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	

}
