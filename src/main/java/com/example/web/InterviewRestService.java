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

import com.example.dao.InterviewRepository;
import com.example.entities.Interview;
import com.example.metier.InterviewMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class InterviewRestService {
	@Autowired
	private InterviewMetier interviewMetier;

	@Autowired
	private InterviewRepository interviewRepository;

	
	@RequestMapping(value ="/Interview" , method = RequestMethod.GET)
	public List<Interview> getInterview(){
		return  interviewMetier.getInterview();
	}

	@RequestMapping(value ="/Interview/{id}" , method = RequestMethod.GET)
	public Interview getInterview(@PathVariable(value="id") Long id_Interview) {
		return  interviewMetier.getOneInterview(id_Interview);
	}

	@RequestMapping(value ="/Interview" , method = RequestMethod.POST)
	public Interview AddInterview(@RequestBody Interview interviewAdd) {
		return interviewMetier.AddInterview(interviewAdd);
	}

	@RequestMapping(value ="/Interview/{id_Interview}" , method = RequestMethod.PUT)
	public ResponseEntity<Interview> EditInterview(@PathVariable long id_Interview ,@RequestBody Interview interviewUpdate ){
		return ResponseEntity.ok(interviewMetier.EditInterview(id_Interview,interviewUpdate));
	}
	
	
	@RequestMapping(value ="/Interview/{id_Interview}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteInterview (@PathVariable long id_Interview){
		interviewMetier.deleteInterview(id_Interview);
	}

	


}