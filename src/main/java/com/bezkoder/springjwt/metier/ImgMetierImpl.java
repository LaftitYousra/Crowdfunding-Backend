package com.bezkoder.springjwt.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Img;
import com.bezkoder.springjwt.repository.ImgRepository;


@Service
public class ImgMetierImpl implements ImgMetier {
	
	
	@Autowired
    private ImgRepository imgRepository;
	
	public Img saveimg( Img img ) {
		return imgRepository.save(img);
		
	}
	

}
