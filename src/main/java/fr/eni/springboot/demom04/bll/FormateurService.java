package fr.eni.springboot.demom04.bll;

import java.util.List;

import fr.eni.springboot.demom04.bo.Formateur;

public interface FormateurService {

	void add(Formateur formateur);
	
	List<Formateur> getFormateurs();
	
	Formateur findByEmail(String emailFormateur);
	
	void update(Formateur formateur);
	
	void updateCoursFormateur(String emailFormateur, long idCours);
}
