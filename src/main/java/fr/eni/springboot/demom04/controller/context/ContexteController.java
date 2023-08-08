package fr.eni.springboot.demom04.controller.context;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.eni.springboot.demom04.bo.Utilisateur;

@Controller
@RequestMapping("/contexte/SessionEtRequest")
//Injection de la liste des attributs en session : utilisateurSession
@SessionAttributes({ "utilisateurSession" })
public class ContexteController {

	@GetMapping
	public String ajoutAttributRequest(@ModelAttribute("utilisateurSession") Utilisateur utilisateurSession,
			@RequestParam(name = "pseudo", required = false) String pseudo, Model model) {

		System.out.println("Ajout d'un utilisateur dans la requête");

		Utilisateur utilisateurRequest = new Utilisateur("Stéphane");
		model.addAttribute("utilisateurRequest", utilisateurRequest);

		System.out.println("Utilisateur en session " + utilisateurSession);
		System.out.println("Paramètre - Pseudo = " + pseudo);
		
		/*
		 * if (null != pseudo) { utilisateurSession.setPseudo(pseudo); } else {
		 * utilisateurSession.setPseudo(null); }
		 * & équivaut à ce qui est plus bas
		 */

		utilisateurSession.setPseudo(pseudo);

		return "contexte/view-contexte";
	}

	
	@GetMapping("/recuperer")
	public String recupererAttributs(@ModelAttribute("utilisateurSession") Utilisateur utilisateurSession, @ModelAttribute("utilisateurRequest") Utilisateur utilisateurRequest) {

		System.out.println("Contexte session user "+ utilisateurSession);
		System.out.println("Contexte request user "+ utilisateurRequest);
		
		return "contexte/view-contexte";
	}
	
	@GetMapping("/deconnexion")
	public String finDeSession(SessionStatus status) {
		//Suppression des attributs de l'annotation "@SessionAttributes"
		status.setComplete();
		return "redirect:/contexte/SessionEtRequest";
	}
	
	@ModelAttribute("utilisateurSession")
	public Utilisateur ajoutUtilisateurSession() {
		System.out.println("Ajout de l'utilisateur en session");
		return new Utilisateur();
	}
}
