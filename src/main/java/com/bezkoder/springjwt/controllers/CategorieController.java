package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.metier.CategorieMetier;
import com.bezkoder.springjwt.models.Categorie;


@RestController
@CrossOrigin(origins = "*")
public class CategorieController {
	
	@Autowired
	private CategorieMetier categorietmetier;
	
	
	@RequestMapping( value = "/categorie", method = RequestMethod.POST )
    public Categorie saveCategorie( @RequestBody Categorie categorie ) {
        return categorietmetier.saveCategorie( categorie );
    }
	
	
	@RequestMapping(value = "/listecategories", method = RequestMethod.GET)
	public List<Categorie> listCategories() {
		return categorietmetier.listCategories();
	}

}
