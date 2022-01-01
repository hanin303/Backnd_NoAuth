package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cv implements Serializable{
	
	@Id 
	@GeneratedValue
	private long idCV;
	private String pdf;
	
	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_User")
    private User user;*/
	
	@JsonIgnore
	@OneToOne(mappedBy = "pdfcv")
    private User user;

	public Cv() {
		super();
	// TODO Auto-generated constructor stub
	}

	
	public Cv( String pdf) {
		super();
		this.pdf = pdf;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}




	public long getIdCV() {
		return idCV;
	}


	public void setIdCV(long idCV) {
		this.idCV = idCV;
	}


	public String getPdf() {
		return pdf;
	}


	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	
}
