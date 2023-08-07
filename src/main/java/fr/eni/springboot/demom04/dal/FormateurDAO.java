package fr.eni.springboot.demom04.dal;

import java.util.List;

import fr.eni.springboot.demom04.bo.Formateur;

public interface FormateurDAO {
	void create(Formateur formateur);

	Formateur read(String emailFormateur);

	void update(Formateur formateur);

	List<Formateur> findAll();
}
