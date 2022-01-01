package com.example.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CompetanceRepository;
import com.example.dao.CondidatRepository;
import com.example.dao.UserRepository;
import com.example.entities.Competance;
import com.example.entities.Condidats;
import com.example.entities.User;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CompetanceRestService {
	
	@Autowired
	UserRepository userRep;
	
	@Autowired
	CondidatRepository condidatRep;
	
	@Autowired
	CompetanceRepository competanceRep;
	
	
	@RequestMapping(value="/competance",method = RequestMethod.GET)
	public List<Competance> getCompetances(){
		return competanceRep.findAll();
	}
	
	@RequestMapping(value="/competance/{idComp}",method = RequestMethod.GET)
    public Competance getCompetance(@PathVariable Long idComp) {
		Optional<Competance> competance = competanceRep.findById(idComp);
		if (competance.isPresent()) { 
			return competance.get();
		}else throw new RuntimeException("Competance introuvable !! ");
	}
	
	@RequestMapping(value="/competance/{idComp}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCompetance(@PathVariable Long idComp) {
		Optional<Competance> competance = competanceRep.findById(idComp);
		if (competance.isPresent()) { 
			Competance cpt = competance.get();
			cpt.setUser(null);
			competanceRep.deleteCompetance(cpt.getIdCompetance());;
		}else throw new RuntimeException("Competance introuvable !! ");	
	}
	
	
	@RequestMapping(value="/competance/{idUser}",method = RequestMethod.POST)
	public void AddCompetance(@RequestBody Competance competance,@PathVariable long idUser){
		Optional<Competance> comp = competanceRep.findById(competance.getIdCompetance());
		if (comp.isPresent() == false) { 
			User cond = userRep.findById(idUser).get();
			competance.setUser(cond);
			competanceRep.save(competance);
		}else throw new RuntimeException("Competance introuvable !! ");	
	 }
   

	@RequestMapping(value="/competance/{idComp}",method = RequestMethod.PUT)
	public Competance EditCompetance(@PathVariable Long idComp, @RequestBody Competance competance){
        Competance c = competanceRep.findById(idComp).orElseThrow(()->new ResourceNotFoundException("Cette competance n'existe pas"));
        	c.setIdCompetance(competance.getIdCompetance());
        	c.setNomCompetance(competance.getNomCompetance());
        	c.setPourcentage(competance.getPourcentage());
		return competanceRep.save(c);
	}
	
	
}