package fr.eni.springboot.demom04.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.eni.springboot.demom04.bo.Formateur;


@Repository
public class FormateurDAOBouchon implements FormateurDAO {

	
	private static final List<Formateur> listeFormateurs;
	
	static {
		listeFormateurs = new ArrayList<>();
		listeFormateurs.add(new Formateur("Stéphane", "Gobin", "sgo@eni.fr"));
		listeFormateurs.add(new Formateur("Anne-Lise", "Baille", "abaille@campus-eni.fr"));
		listeFormateurs.add(new Formateur("Julien", "Trillard", "jtr@eni.fr"));
		listeFormateurs.add(new Formateur("Coach", "Par défaut", "coach@eni.fr"));
	}
	
	@Override
	public void create(Formateur formateur) {
		listeFormateurs.add(formateur);
	}

	@Override
	public List<Formateur> findAll() {
		return listeFormateurs;
	}

	@Override
	public Formateur findByEmail(String email) {
		
		return listeFormateurs.stream().filter(item -> item.getEmail().equals(email)).findAny().orElse(null);
	}
	
	

}
