package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Competance implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idCompetance;
	private String nomCompetance;
	private int pourcentage;
	
	
	@ManyToOne
	@JoinColumn(name="IdUser")
	private User user;
	
	
	public Competance() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Competance(Long idCompetance, String nomCompetance, int pourcentage) {
		super();
		this.idCompetance = idCompetance;
		this.nomCompetance = nomCompetance;
		this.pourcentage = pourcentage;
	}


	public Long getIdCompetance() {
		return idCompetance;
	}


	public void setIdCompetance(Long idCompetance) {
		this.idCompetance = idCompetance;
	}


	public String getNomCompetance() {
		return nomCompetance;
	}


	public void setNomCompetance(String nomCompetance) {
		this.nomCompetance = nomCompetance;
	}


	public int getPourcentage() {
		return pourcentage;
	}


	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
