package fr.eni.springboot.demom04.bll;

import java.util.List;

import fr.eni.springboot.demom04.bo.Formateur;



public interface FormateurService {

	void add(String nom, String prenom, String email);
	List<Formateur> getFormateurs(); 
	public Formateur findByEmail(String email);
}
