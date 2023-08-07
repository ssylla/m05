package fr.eni.springboot.demom04.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Formateur implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String email;
	
	private List<Cours> cours;
	
	{
		cours = new ArrayList<>();
	}
	
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
	
	

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Formateur [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
}
