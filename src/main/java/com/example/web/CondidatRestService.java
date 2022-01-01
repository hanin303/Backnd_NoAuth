package com.example.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.example.dao.CVRepository;
import com.example.entities.Condidats;
import com.example.entities.Interview;
import com.example.metier.InterCondidatMetier;
import com.example.dao.*;
import com.example.entities.OffreEmploi;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CondidatRestService {
	
	@Autowired
	private InterCondidatMetier condMetier;
	
	@Autowired
	CVRepository cvRep;
	
	@Autowired
	OffreEmploiRepository offerRep;
	
	@Autowired
	CondidatRepository CondRep;
	
	
	
	@RequestMapping(value="/condidats",method = RequestMethod.GET)
	public List<Condidats> getCondidats(){
		return condMetier.getCondidat();
	}
	
	
	@RequestMapping(value="/condidats/{iduser}",method = RequestMethod.GET)
    public Condidats getCondidats(@PathVariable long iduser) {
		return condMetier.getOneCondidat(iduser);
	}
	
	
	
	@RequestMapping(value="/condidats/{iduser}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable long iduser) {
			condMetier.deleteCondidat(iduser);
	}
	
	@RequestMapping(value="/condidats/{idOffre}",method = RequestMethod.POST)
	public void AddCondidat(@RequestBody Condidats user,@PathVariable long idOffre){
		List<Condidats> CondidatList = this.getCondidats();	
		Condidats CondAj = new Condidats();
		boolean Test = false;
		for(int i = 0 ;i<CondidatList.size();i++) {
			if(CondidatList.get(i).getCin() == user.getCin()) {
				Test = true;
				CondAj =CondidatList.get(i); 
			}else {
				Test = false;
			}
		}
		if (Test == false) { 
		  	OffreEmploi offer = offerRep.findById(idOffre).get();
		  	Interview interview = new Interview();
			interview.setUser(user);
			interview.setOffre(offer);
			Set<Interview> ListInterv =new HashSet<Interview>() ;
			ListInterv.add(interview);
			user.setInterview(ListInterv);
			CondRep.save(user);
    	}else {
    		OffreEmploi offer = offerRep.findById(idOffre).get();
		  	Interview interview = new Interview();
			interview.setUser(CondAj);
			interview.setOffre(offer);
			Set<Interview> ListInterv =new HashSet<Interview>() ;
			ListInterv.add(interview);
			CondAj.setInterview(ListInterv);
			CondRep.save(CondAj);
    		
    	}
	}
	

	
	@RequestMapping(value="/condidats/{iduser}",method = RequestMethod.PUT)
	public ResponseEntity<Condidats> EditCondidat(@PathVariable long iduser, @RequestBody Condidats user){
		 return ResponseEntity.ok(condMetier.EditCondidat(iduser, user));
    }


}
