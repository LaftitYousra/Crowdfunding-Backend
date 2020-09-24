package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.metier.ProjetFinanceMetier;
import com.bezkoder.springjwt.models.Projet;
import com.bezkoder.springjwt.models.Projets_Finances;

@RestController
@CrossOrigin(origins = "*")
public class ProjetFinanceController {
	
	@Autowired
	public ProjetFinanceMetier projetfinancemetier;
	
	@RequestMapping( value = "/Saveprojet", method = RequestMethod.POST )
	 public Projets_Finances saveProjet( @RequestBody Projets_Finances projet ) {
        return projetfinancemetier.SaveFuncedProject( projet );
    }
	
	 @RequestMapping( value = "/soutenir", method = RequestMethod.POST )
	    public boolean soutenir(
	    		@RequestBody Projets_Finances fprojet,
	    		@RequestParam Long idprojet,
	    		@RequestParam double montant) {
	        return projetfinancemetier.soutenir(fprojet, idprojet, montant);
	    }
	
	
	@RequestMapping(value = "/listeFuncedprojects", method = RequestMethod.GET)
	public List<Projets_Finances> listAllProjets() {
		return projetfinancemetier.listFuncedProjets();
	}
	

	 @RequestMapping(value = "/DeleteProjet/{id}", method = RequestMethod.DELETE)
		public List<Projets_Finances> deleteProject(@PathVariable Long id) {
			return projetfinancemetier.deleteFinanceProjet(id);
		}
		
	 @RequestMapping(value = "/updateProject", method = RequestMethod.PUT)
		 public Projets_Finances updateProject(@RequestBody Projets_Finances projet) {
		 return projetfinancemetier.updateProjet(projet);
		 }
	 
	 @RequestMapping(  value = "/findMyProject/{id}", method = RequestMethod.GET )
	    public List<Projets_Finances> getProjetByInvestisseur( @PathVariable Long id ) {
	        return projetfinancemetier.getProjetByInvestisseur( id );
	    }
	 

	 @RequestMapping(  value = "/findMyProjet/{id}", method = RequestMethod.GET )
	    public List<Projets_Finances> findProjetById( @PathVariable Long id ) {
	        return projetfinancemetier.findProjetById( id );
	    }
	

}
