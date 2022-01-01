package com.example.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="QUESTIONS")
public class Questions implements Serializable{
	@Id @GeneratedValue
	private Long id_Question;
	private String Question;
	
	@OneToMany(mappedBy="id_Questionnaire",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Questionnaire> questionnaires ;
	
	public Questions(Long id_Question, String question) {
		super();
		this.id_Question = id_Question;
		Question = question;
	}
	public Questions () {}
	public Long getId_Question() {
		return id_Question;
	}
	public void setId_Question(Long id_Question) {
		this.id_Question = id_Question;
	}
	public String getQuestion() {
		return Question;
	}
	public Set<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}
	public void setQuestionnaires(Set<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	
}
