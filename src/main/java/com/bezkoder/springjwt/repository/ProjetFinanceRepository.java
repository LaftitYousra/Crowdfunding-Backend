package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Projets_Finances;

@Repository
public interface ProjetFinanceRepository extends JpaRepository<Projets_Finances, Long> {
	
	@Query("select projet from Projets_Finances projet where projet.investisseur.id=:x")
	public List<Projets_Finances> getProjets( @Param("x") Long id);
	
	List<Projets_Finances> findByid(long id);

}
