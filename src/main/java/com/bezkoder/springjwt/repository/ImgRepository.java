package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Img;
import com.bezkoder.springjwt.models.Projet;

@Repository
public interface ImgRepository extends JpaRepository<Img, Long> {

}
