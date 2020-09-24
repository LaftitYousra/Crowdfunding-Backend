package com.bezkoder.springjwt.metier;

import java.util.List;
import com.bezkoder.springjwt.models.Categorie;


public interface CategorieMetier {
	
	public Categorie saveCategorie( Categorie categorie );
	public List<Categorie> listCategories();

}
