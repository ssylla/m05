package fr.eni.springboot.demom04.bo;

import java.io.Serializable;

public class Formateur implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String email;
	
	public Formateur() {}
	
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

	@Override
	public String toString() {
		return "Formateur [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
}
