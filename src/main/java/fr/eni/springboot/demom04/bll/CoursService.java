package fr.eni.springboot.demom04.bll;
import java.util.List;

import fr.eni.springboot.demom04.bo.Cours;

public interface CoursService {
	List<Cours> getCours();

	Cours findById(long id);
}
