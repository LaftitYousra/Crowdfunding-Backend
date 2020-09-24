package com.bezkoder.springjwt.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bezkoder.springjwt.models.Projet;
import com.bezkoder.springjwt.models.Projets_Finances;
import com.bezkoder.springjwt.repository.ProjetFinanceRepository;
import com.bezkoder.springjwt.repository.ProjetRepository;


@Service
public class ProjetFinanceImplMetier implements ProjetFinanceMetier {
	
	@Autowired
    private ProjetFinanceRepository projetfinanceRepository;
	@Autowired
    private ProjetRepository projetRepository;

	@Override
	public Projets_Finances SaveFuncedProject(Projets_Finances projet) {
		projet.setDate_financement(new Date());
		return projetfinanceRepository.save(projet);
	}
	
	@Override
	public List<Projets_Finances> listFuncedProjets() {
		return projetfinanceRepository.findAll();
	}
	
	@Override
	public Projets_Finances updateProjet(Projets_Finances projet) {
		return projetfinanceRepository.save(projet) ;
	}
	
	@Override
	public List<Projets_Finances> deleteFinanceProjet(Long idProjet) {
		projetfinanceRepository.deleteById(idProjet);
		return projetfinanceRepository.findAll() ;
	}
	
	
    //By investisseur
	@Override
	public List<Projets_Finances> getProjetByInvestisseur(@PathVariable Long id) {
		return projetfinanceRepository.getProjets(id) ;
	}
    
	//By ID
	@Override
	public List<Projets_Finances> findProjetById(@PathVariable Long id) {
		return projetfinanceRepository.findByid(id) ;
	}
	
	
	@Override
    @Transactional // si tous ce passe bien la transaction et faite
	public boolean soutenir(Projets_Finances fprojet, Long idprojet, double montant ) {
		
		Projet projet = projetRepository.findById(idprojet).orElse(null);
		
		//Projets_Finances projetf = new Projets_Finances();
		
		fprojet.setDate_financement(new Date());

		projet.setSolde(projet.getSolde() + montant);
		
		projetfinanceRepository.save(fprojet);
		return true;
		
	}

	

}
