package com.bezkoder.springjwt.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Categorie;
import com.bezkoder.springjwt.repository.CategorieRepository;



@Service
public class CategorieMetierImpl implements CategorieMetier {
	
	@Autowired
    private CategorieRepository categorieRepository;

	@Override
	public Categorie saveCategorie(Categorie categorie) {
		return categorieRepository.save(categorie) ;
	}

	@Override
	public List<Categorie> listCategories() {
		return categorieRepository.findAll();
	}

}
