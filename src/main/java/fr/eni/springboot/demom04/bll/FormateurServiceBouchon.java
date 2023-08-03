package fr.eni.springboot.demom04.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.springboot.demom04.bo.Formateur;

//@Service
//@Profile("dev")
public class FormateurServiceBouchon implements FormateurService {
	
	private static List<Formateur> lstFormateurs;
	
	static {
		System.out.println("La classe est chargée");
		lstFormateurs = new ArrayList<>();
		lstFormateurs.add(new Formateur("Thierry", "Largeau", "tla@eni.fr"));
		lstFormateurs.add(new Formateur("Julien", "Denis", "jde@eni.fr"));
	}

	{
		System.out.println("Un ouvel objet est créé");
	}

	@Override
	public void add(String nom, String prenom, String email) {
		Formateur formateur = new Formateur(nom, prenom, email);
		lstFormateurs.add(formateur);
	}

	@Override
	public List<Formateur> getFormateurs() {
		return lstFormateurs;
	}

	@Override
	public Formateur findByEmail(String email) {
		return lstFormateurs.stream().filter(item -> item.getEmail().equals(email)).findAny().orElse(null);
	}
}
