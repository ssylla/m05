package fr.eni.springboot.demom04.dal;
import java.util.List;

import fr.eni.springboot.demom04.bo.Cours;

public interface CoursDAO {
	
	Cours read(long id);

	List<Cours> findAll();
	
	List<Cours> findByFormateur(String email);
	
	void insertCoursFormateur(long idCours, String emailFormateur);
}
