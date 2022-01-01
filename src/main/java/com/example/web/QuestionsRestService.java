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

import com.example.entities.Questions;
import com.example.metier.QuestionsMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class QuestionsRestService {
	@Autowired
	private QuestionsMetier questionsMetier;

	@RequestMapping(value ="/Questions" , method = RequestMethod.GET)
	public List<Questions> getQuestions(){
		return  questionsMetier.getQuestions();
	}

	@RequestMapping(value ="/Questions/{id}" , method = RequestMethod.GET)
	public Questions getQuestions(@PathVariable(value="id") Long id_Question) {
		return  questionsMetier.getOneQuestion(id_Question);
	}

	@RequestMapping(value ="/Questions" , method = RequestMethod.POST)
	public Questions AddQuestions(@RequestBody Questions questionsAdd) {
		return questionsMetier.AddQuestions(questionsAdd);
	}

	@RequestMapping(value ="/Questions/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Questions> EditQuestions(@PathVariable(value="id") long id_Question ,@RequestBody Questions questionsUpdate ){
		return ResponseEntity.ok(questionsMetier.EditQuestions(id_Question, questionsUpdate));
	}
	@RequestMapping(value ="/Questions/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteQuestions (@PathVariable(value="id") long id_Question){
		questionsMetier.deleteQuestions(id_Question);
	}

}

