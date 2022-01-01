package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.OffreEmploi;
import com.example.metier.InterOffreEmploiMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class OffreEmploiRestService {

	@Autowired
	private InterOffreEmploiMetier OffreMetier;
	
	
	@RequestMapping(value="/offers",method = RequestMethod.GET)
	public List<OffreEmploi> getOffers(){
		return OffreMetier.getOffres();	
	}
	
	
	@RequestMapping(value="/offers",method = RequestMethod.POST)
	public OffreEmploi AddOffre(@RequestBody OffreEmploi addOffre){
	       return OffreMetier.AddOffre(addOffre);
	}
	
	@RequestMapping(value="/offers/{code}",method = RequestMethod.GET)
    public OffreEmploi getOffreById(@PathVariable long code) {
		return OffreMetier.getOffre(code);
	}
	
	
	@RequestMapping(value="/offers/{code}",method = RequestMethod.DELETE)
	@ResponseBody
    public void delete(@PathVariable long code){
		OffreMetier.deleteOffre(code);
     }
	
	
	@RequestMapping(value="/offers/{code}",method = RequestMethod.PUT)
	public ResponseEntity<OffreEmploi> updateOffre(@PathVariable long code,@RequestBody OffreEmploi o){
	   return ResponseEntity.ok(OffreMetier.EditOffre(code, o));
	}
}
