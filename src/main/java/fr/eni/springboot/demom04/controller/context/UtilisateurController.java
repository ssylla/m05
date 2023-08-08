package fr.eni.springboot.demom04.controller.context;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.springboot.demom04.bo.Utilisateur;

@Controller
@RequestMapping("/contexte/utilisateur")
@SessionAttributes({"utilisateurSession"})
public class UtilisateurController {

	
	@GetMapping
	public String utilisateurDetail(@ModelAttribute("utilisateurSession") Utilisateur utilisateurSession) {
		
		System.out.println("Utilisateur en session autre controlleur "+ utilisateurSession);
		return "contexte/view-utilisateur";
	}
	
	
	@ModelAttribute("utilisateurSession") 
	public Utilisateur ajoutUtilisateurSessionAutreControlleur() {
		System.out.println("ajoutUtilisateurSessionAutreControlleur");
		return new Utilisateur("Anne-Lise");
	}
}
