package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.Categorie;

public interface CategorieRepo extends JpaRepository<Categorie, Long> {
	List<Categorie> findByAnnee(int annee);
	Categorie findByDescription(String description);
}
