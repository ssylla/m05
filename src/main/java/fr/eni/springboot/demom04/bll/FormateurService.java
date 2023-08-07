package fr.eni.springboot.demom04.bll;

import java.util.List;

import fr.eni.springboot.demom04.bo.Formateur;

public interface FormateurService {
	void add(String nom, String prenom, String email);

	List<Formateur> getFormateurs();
	
	Formateur findByEmail(String emailFormateur);
	
	void update(Formateur formateur);
	
	void updateCoursFormateur(String emailFormateur, long idCours);
}
