package com.bezkoder.springjwt.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.springjwt.models.Projet;
import com.bezkoder.springjwt.repository.ImgRepository;
import com.bezkoder.springjwt.repository.ProjetRepository;



@Service
public class ProjetMetierImpl implements ProjetMetier {
	
	@Autowired
    private ProjetRepository projetRepository;
	@Autowired
	ImgRepository imgRepository;
	

	@Override
	public Projet saveProjet(Projet projet) {
		projet.setDate_ajout(new Date());
		projet.setStatus("nonactive");
		projet.setIsCloture(false);
		//projet.setPath_image(file.getOriginalFilename());
		return projetRepository.save(projet);
	}
	
	

	@Override
	public List<Projet> getProjet(@PathVariable Long id) {
		return projetRepository.findByid(id);
				//findBycodeProjet(idProjet);
	}
	
		@Override
		public List<Projet> findProjet(@PathVariable Long id ) {
			return projetRepository.getProjets(id);
		}
		
		@Override
		public List<Projet> getActiveProjets(@PathVariable String status) {
			return projetRepository.getActiveProjets(status);
		}
		
		@Override
		public List<Projet> getNonActiveProjets(String status){
			return projetRepository.getnonActiveProjets(status);
		}
		
		@Override
		public List<Projet> getProjetsByCat(@PathVariable String categorie) {
			return projetRepository.getProjetByCat(categorie);
		}



		@Override
		public List<Projet> getAllProjetsByCat(@PathVariable String categorie) {
			return projetRepository.getAllProjetByCat(categorie);
		}
	

	@Override
	public List<Projet> listProjets() {	
	   return projetRepository.findAll() ;
	}

	@Override
	public List<Projet> deleteProjet(@PathVariable Long idProjet) {
		projetRepository.deleteById(idProjet);
		return projetRepository.findAll() ;
	}
	
/*	@Override
	public Projet valider(Projet projet) {
		projet.setStatus("valide");
		return projetRepository.save(projet);
	}*/
	
	
	@Override
	public Projet update(Projet projet) {
		return projetRepository.save(projet);
	}
	
        
	
	
	@Override
    @Transactional // si tous ce passe bien la transaction et faite
	public boolean valider(@PathVariable Long id, String status ) {
		
		Projet projet = projetRepository.findById(id).orElse(null);
		projet.setStatus(status);
		projetRepository.save(projet);
		return true;
		
	}



	



	
	
	



	
	


	



	

	
}
