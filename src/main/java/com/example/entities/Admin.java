package com.example.entities;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="admin")
public class Admin extends User{
	private Date DateEmbauche;
	
	
	
	public Admin() {
		super();
		
	}

	public Admin(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo, String competance,Cv pdfcv, Date dateEmbauche) {
		super(idUser,nom,prenom,email,adress,cin,tel,photo, competance,pdfcv);
		
		DateEmbauche = dateEmbauche;
	}


	public Date getDateEmbauche() {
		return DateEmbauche;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}

}
