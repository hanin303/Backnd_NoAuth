package com.example.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("condidats")
public class Condidats extends User{

	
	public Condidats() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Condidats(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo,Cv pdfcv,String LienG,String LienF,String LienI,String LienL) {
		super(idUser,nom,prenom,email,adress,cin,tel,photo,pdfcv,LienG,LienF,LienI,LienL);
		// TODO Auto-generated constructor stub
	}
	
}
