package com.example.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.JoinTable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToMany;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_user",discriminatorType=DiscriminatorType.STRING,length=15)
public class User implements Serializable , UserDetails{

	@Id
	@GeneratedValue
	private Long idUser;
	private String Nom;
	private String Prenom;
	private String Email;
	private String Adress;
	private int Cin;
	private int tel;
	private String photo;
	private String LienGithub;
	private String LienFacebook;
	private String LienLinkedIn;
	private String LienInstagram;
	private Date DateEmbauche;
	
	private String Competance;
	private int isAdmin;
	
	private String username;
	private String password;
	private Boolean enabled;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Interview>interview;
	
	/*@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Competance> competances ;*/
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="users_roles" , joinColumns = @JoinColumn(name="idUser") , inverseJoinColumns=@JoinColumn(name="idRole"))
	@JsonIgnore
	private Set<Role> roles = new HashSet<>();


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id")
	private Cv pdfcv;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo,Cv pdfcv,String LienG,String LienF,String LienI,String LienL) {
		super();
		this.idUser = idUser;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Email = email;
		this.Adress = adress;
		this.Cin = cin;
		this.tel = tel;
		this.photo = photo;
		this.pdfcv = pdfcv;
		this.LienFacebook=LienF;
		this.LienGithub=LienG;
		this.LienInstagram=LienI;
		this.LienLinkedIn=LienL;
	}
	

	
	public User(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo, String competance,Cv pdfcv) {
		super();
		this.idUser = idUser;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Email = email;
		this.Adress = adress;
		this.Cin = cin;
		this.tel = tel;
		this.photo = photo;
		this.Competance = competance;
		this.pdfcv = pdfcv;
		isAdmin=0;
	}

	public String getCompetance() {
		return Competance;
	}


	public void setCompetance(String competance) {
		Competance = competance;
	}


	public int getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}


	public String getLienGithub() {
		return LienGithub;
	}


	public void setLienGithub(String lienGithub) {
		LienGithub = lienGithub;
	}


	public String getLienFacebook() {
		return LienFacebook;
	}


	public void setLienFacebook(String lienFacebook) {
		LienFacebook = lienFacebook;
	}


	public String getLienLinkedIn() {
		return LienLinkedIn;
	}


	public void setLienLinkedIn(String lienLinkedIn) {
		LienLinkedIn = lienLinkedIn;
	}


	public String getLienInstagram() {
		return LienInstagram;
	}


	public void setLienInstagram(String lienInstagram) {
		LienInstagram = lienInstagram;
	}


	/*public Set<Competance> getCompetances() {
		return competances;
	}

	public void setCompetances(Set<Competance> competances) {
		this.competances = competances;
	}
	
*/
	
	
	
	public Long getIdUser() {
		return idUser;
	}
	
	public Date getDateEmbauche() {
		return DateEmbauche;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public int getCin() {
		return Cin;
	}
	public void setCin(int cin) {
		Cin = cin;
	}
	
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Set<Interview> getInterview() {
		return interview;
	}
	public void setInterview(Set<Interview> interview) {
		this.interview = interview;
	}
	public Cv getPdfcv() {
		return pdfcv;
	}
	public void setPdfcv(Cv pdfcv) {
		this.pdfcv = pdfcv;
	}

	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean isAccountNonExpired() {
	return false;
	}
	
	@Override
	public boolean isAccountNonLocked() {
	return false;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
	return false;
	}
	
	@Override
	public boolean isEnabled() {
	return false;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = this.getRoles();           
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		            
		            for (Role role : roles) {
		                authorities.add(new SimpleGrantedAuthority(role.getName()));
		            }
		            
		            return authorities;
	}
	
	

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email + ", Adress="
				+ Adress + ", Cin=" + Cin + ", tel=" + tel + ", photo=" + photo +
				 ", interview=" + interview + ", roles=" + roles + ", pdfcv=" + pdfcv + "]";
	}
	
}
