package com.example.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name="INTERVIEW")
public class Interview implements Serializable {
	@Id @GeneratedValue
	private Long id_Interview;
	private Date interviewDate;
	private String interviewType;
	private String location;
	private String time;
	private int test;
	private int note;
	
	@ManyToOne
	@JoinColumn(name="idOffre")
	private OffreEmploi offre ;
	
	@OneToMany(mappedBy="interview",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Questionnaire> questionnaires ;
	
	@ManyToOne
	@JoinColumn(name="IdUser")

	private User user;
	
	public Interview () {
		super();
	}
	
	public Interview(Long id_Interview, Date interviewDate, String interviewType, String location , String time,
			int test) {
		super();
		this.id_Interview = id_Interview;
		this.interviewDate = interviewDate;
		this.interviewType = interviewType;
		this.location = location;
		this.time = time;
		this.test=test;
		this.note = 0;
	}
	
	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public Long getId_Interview() {
		return id_Interview;
	}
	public void setId_Interview(Long id_Interview) {
		this.id_Interview = id_Interview;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public OffreEmploi getOffre() {
		return offre;
	}

	public void setOffre(OffreEmploi offre) {
		this.offre = offre;
	}

	public Set<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(Set<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}