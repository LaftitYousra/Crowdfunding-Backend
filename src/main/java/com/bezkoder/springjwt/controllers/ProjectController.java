package com.bezkoder.springjwt.controllers;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.bezkoder.springjwt.metier.ImgMetier;
import com.bezkoder.springjwt.metier.ProjetMetier;
import com.bezkoder.springjwt.models.Projet;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.Img;
import com.bezkoder.springjwt.models.Response;
import javax.servlet.ServletContext;
import org.apache.commons.io.*;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {
	
	@Autowired
	private ProjetMetier projetmetier;
	
	@Autowired
	private ImgMetier imgmetier;
	
	@Autowired
	ServletContext context;
	
	
	@PostMapping(value="/test")
	public ResponseEntity<Response> saveuserProfile(@RequestParam("file") MultipartFile file) throws IOException{
		
		Img image=new Img();
		image.setLogo(file.getBytes());
		image.setFileName(file.getOriginalFilename());
		Img dbimage = imgmetier.saveimg(image);
		
		return new ResponseEntity<Response>(new Response(""), HttpStatus.OK);
		
	}
	
	/*@PostMapping(value="/test")
	public ResponseEntity<Response> saveuserProfile(@RequestParam("file") MultipartFile file){
		Img image=new Img();
		
		boolean isExist = new File (context.getRealPath("/userprofile/")).exists();
		if(!isExist) { new File(context.getRealPath("/userprofile/")).mkdir();}
		
		String filename = file.getOriginalFilename();
		String modifiedfilename = FilenameUtils.getBaseName(filename);
		File serverfile = new File(context.getRealPath("/userprofile/"+File.separator+modifiedfilename));
		try {
			FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
		}
		catch(Exception e){e.printStackTrace();}
		
		image.setFileName(modifiedfilename);
		Img img = imgmetier.saveimg(image);
		if(img!=null) { return new ResponseEntity<Response> (new Response ("success"), HttpStatus.OK);}
		else {return new ResponseEntity<Response> (new Response ("failed"), HttpStatus.BAD_REQUEST);}
		
	}*/
	
	@RequestMapping( value = "/projet", method = RequestMethod.POST )
    public Projet saveProjet( @RequestBody Projet projet) {
        return projetmetier.saveProjet( projet);
    }
	
	
	@RequestMapping(value = "/listeprojets", method = RequestMethod.GET)
	public List<Projet> listProjets() {
		return projetmetier.listProjets();
	}
	
	 /*@RequestMapping(  value = "/projet", method = RequestMethod.GET )
	    public List<Projet> getProjet(@RequestParam User user) {
	        return projetmetier.getProjet( user );
	    }*/
	 
	 @RequestMapping(value = "/projet/{id}", method = RequestMethod.DELETE)
		public List<Projet> deleteProjet(@PathVariable Long id) {
			return projetmetier.deleteProjet(id);
		}
	 
	 
	 @RequestMapping(  value = "/find/{id}", method = RequestMethod.GET )
	    public List<Projet> getprojet( @PathVariable Long id ) {
	        return projetmetier.findProjet( id );
	    }
	 

	 @RequestMapping(  value = "/findProjet/{id}", method = RequestMethod.GET )
	    public List<Projet> getProjet( @PathVariable Long id ) {
	        return projetmetier.getProjet( id );
	    }
	 
	 @RequestMapping(  value = "/findactive/{status}", method = RequestMethod.GET )
	    public List<Projet> getActiveProjet( @PathVariable String status ) {
	        return projetmetier.getActiveProjets( status );
	    }
	 
	 @RequestMapping(  value = "/findnonactive/{status}", method = RequestMethod.GET )
	    public List<Projet> getNonActiveProjet( @PathVariable String status ) {
	        return projetmetier.getNonActiveProjets( status );
	    }
	 
	 @RequestMapping(  value = "/projetByCategorie/{categorie}", method = RequestMethod.GET )
	    public List<Projet> getProjetByCat( @PathVariable String categorie ) {
	        return projetmetier.getProjetsByCat( categorie );
	    }
	 
	 @RequestMapping(  value = "/AllProjetByCategorie/{categorie}", method = RequestMethod.GET )
	    public List<Projet> getAllProjetByCat( @PathVariable String categorie ) {
	        return projetmetier.getAllProjetsByCat( categorie );
	    }
	 
	 @RequestMapping( value = "/valider/{id}", method = RequestMethod.PUT )
	    public boolean valider(
	    		@PathVariable Long id,
	            @RequestParam String status) {
	        return projetmetier.valider( id, status );
	    }
	 
	 @RequestMapping(value = "/update", method = RequestMethod.PUT)
	 public Projet update(@RequestBody Projet projet) {
	 return projetmetier.update(projet);
	 }

}
