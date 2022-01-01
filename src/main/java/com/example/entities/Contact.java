package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="CONTACT")
public class Contact implements Serializable{
	@Id
	@GeneratedValue
	private Long id_Contact;
	private String Nom;
	private String Prenom;
	private String Email;
	private String Comment;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(Long id_Contact, String nom, String prenom, String email, String comment) {
		super();
		this.id_Contact = id_Contact;
		Nom = nom;
		Prenom = prenom;
		Email = email;
		Comment = comment;
	}

	public Long getId_Contact() {
		return id_Contact;
	}

	public void setId_Contact(Long id_Contact) {
		this.id_Contact = id_Contact;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}



}
