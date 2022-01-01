package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Questionnaire implements Serializable{
	
		@Id @GeneratedValue
		private Long id_Questionnaire;
		private int Validate;
		
		@ManyToOne
		@JoinColumn(name="id_Interview")
		private Interview interview ;
		
		@ManyToOne
		@JoinColumn(name="id_Question")
		private Questions question;
		
		public Questionnaire() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Questionnaire(Long id_Questionnaire, int validate) {
			super();
			this.id_Questionnaire = id_Questionnaire;
			Validate = validate;
		}

		public Long getId_Questionnaire() {
			return id_Questionnaire;
		}

		public void setId_Questionnaire(Long id_Questionnaire) {
			this.id_Questionnaire = id_Questionnaire;
		}

		public int getValidate() {
			return Validate;
		}

		public void setValidate(int validate) {
			Validate = validate;
		}

		public Interview getInterview() {
			return interview;
		}

		public void setInterview(Interview interview) {
			this.interview = interview;
		}

		public Questions getQuestion() {
			return question;
		}

		public void setQuestion(Questions question) {
			this.question = question;
		}


		
		
}
