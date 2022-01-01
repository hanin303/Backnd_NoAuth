package com.example.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="interviewer")
public class Interviewer extends User{
	
	private String Pwd;
	private Date DateEmbauche;
	
	
	public Interviewer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Interviewer(Long idUser, String nom, String prenom, String email, String adress, int cin, int tel,
			String photo, Cv pdfcv,String LienG,String LienF,String LienI,String LienL) {
		super(idUser,nom,prenom,email,adress,cin,tel,photo,pdfcv,LienG,LienF,LienI,LienL);
		// TODO Auto-generated constructor stub
	}


	public Interviewer(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo,Cv pdfcv,String pwd, Date dateEmbauche,String LienG,String LienF,String LienI,String LienL) {
		super(idUser,nom,prenom,email,adress,cin,tel,photo,pdfcv,LienG,LienF,LienI,LienL);
		Pwd = pwd;
		DateEmbauche = dateEmbauche;
	}


	public String getPwd() {
		return Pwd;
	}


	public void setPwd(String pwd) {
		Pwd = pwd;
	}


	public Date getDateEmbauche() {
		return DateEmbauche;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}

}
