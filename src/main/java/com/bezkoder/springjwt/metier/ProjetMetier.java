package com.bezkoder.springjwt.metier;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.springjwt.models.Projet;
import com.bezkoder.springjwt.models.User;


public interface ProjetMetier {
	
	public Projet saveProjet( Projet projet);
	
    public List<Projet> getProjet(Long id);
    
    public List<Projet> listProjets();
    
    public List<Projet> deleteProjet(Long idProjet);
    
    public List<Projet> findProjet(Long id );
    
    public Projet update(Projet projet);
    
    public boolean valider( Long id, String status );
    
    public List<Projet> getActiveProjets(String status);
    
    public List<Projet> getNonActiveProjets(String status);
    
    public List<Projet> getProjetsByCat(String categorie);
    
    public List<Projet> getAllProjetsByCat(String categorie);
    
    

}
