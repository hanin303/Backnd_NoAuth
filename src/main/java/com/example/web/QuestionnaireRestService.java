package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.Questionnaire;
import com.example.entities.Questions;
import com.example.metier.QuestionnaireMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class QuestionnaireRestService {
	@Autowired
	private QuestionnaireMetier questionnaireMetier;

	@RequestMapping(value ="/Questionnaire" , method = RequestMethod.GET)
	public List<Questionnaire> getQuestionnaire(){
		return  questionnaireMetier.getQuestionnaire();
	}

	@RequestMapping(value ="/Questionnaire/{id}" , method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')  or hasAuthority('INTERVIEWER') ")
	public Questionnaire getQuestionnaire(@PathVariable(value="id") Long id_Questionnaire) {
		return  questionnaireMetier.getOneQuestionnaire(id_Questionnaire);
	}

	@RequestMapping(value ="/Questionnaire" , method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('INTERVIEWER')")
	public Questionnaire AddQuestionnaire(@RequestBody Questionnaire questionnaireAdd) {
		return questionnaireMetier.AddQuestionnaire(questionnaireAdd);
	}

	@RequestMapping(value ="/Questionnaire/{id}" , method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('INTERVIEWER')")
	public ResponseEntity<Questionnaire> EditQuestionnaire(@PathVariable(value="id") long id_Questionnaire ,@RequestBody Questionnaire questionnaireUpdate ){
		return ResponseEntity.ok(questionnaireMetier.EditQuestionnaire(id_Questionnaire, questionnaireUpdate));
	}
	@RequestMapping(value ="/Questionnaire/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	@PreAuthorize(" hasAuthority('INTERVIEWER')")
	public void deleteQuestionnaire(@PathVariable(value="id") long id_Questionnaire){
		questionnaireMetier.deleteQuestionnaire(id_Questionnaire);
	}

}

