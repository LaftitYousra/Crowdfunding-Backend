package com.bezkoder.springjwt.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Projet;
import com.bezkoder.springjwt.models.User;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
	
	//List<Projet> findByUser(User userid);
	@Query("select projet from Projet projet where projet.user.id=:x")
    public List<Projet> getProjets( @Param("x") Long id);
	
	@Query("select projet from Projet projet where projet.status=:x")
	public List<Projet> getActiveProjets( @Param("x") String status);
	
	@Query("select projet from Projet projet where projet.categorie.nom=:x and projet.status='nonactive' ")
	public List<Projet> getProjetByCat(@Param("x") String categorie);
	
	@Query("select projet from Projet projet where projet.categorie.nom=:x and projet.status='active' ")
	public List<Projet> getAllProjetByCat(@Param("x") String categorie);
	
	@Query("select projet from Projet projet where projet.status=:x")
	public List<Projet> getnonActiveProjets( @Param("x") String status);
	
	
	
	List<Projet> findByid(long id);

}

