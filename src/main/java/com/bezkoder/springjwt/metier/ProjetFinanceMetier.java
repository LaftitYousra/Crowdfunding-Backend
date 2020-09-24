package com.bezkoder.springjwt.metier;

import java.util.List;


import com.bezkoder.springjwt.models.Projets_Finances;

public interface ProjetFinanceMetier {
	

	public Projets_Finances SaveFuncedProject( Projets_Finances projet );
	
    public List<Projets_Finances> getProjetByInvestisseur(Long id);
    
    public List<Projets_Finances> listFuncedProjets();
    
    public List<Projets_Finances> deleteFinanceProjet(Long idProjet);
    
    public List<Projets_Finances> findProjetById(Long id );
    
    public Projets_Finances updateProjet(Projets_Finances projet);
    
    public boolean soutenir(Projets_Finances fprojet, Long idprojet, double montant );

}
