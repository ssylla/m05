package fr.eni.springboot.demom04.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;//JSR 303
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Formateur implements Serializable {

	private static final long serialVersionUID = 1L;
	//@NotBlank
	//@Size( max = 250, message = "Le nom doit avoir au moins 4 caractères", min = 2)
	private String nom;
	@NotBlank
	@Size(min = 2, max = 250)
	private String prenom;
	@NotBlank
	@Email
	@Pattern(regexp = "^[\\w-\\.]+@campus-eni.fr$")
	private String email;

	private Cours coursPrincipal;
	
	private List<Cours> cours;

	{
		cours = new ArrayList<>();
	}

	public Formateur() {
	}

	public Formateur(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Cours getCoursPrincipal() {
		return coursPrincipal;
	}

	public void setCoursPrincipal(Cours coursPrincipal) {
		this.coursPrincipal = coursPrincipal;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Formateur [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", coursPrincipal="
				+ coursPrincipal + "]";
	}	
}
