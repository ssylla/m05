package fr.eni.springboot.demom04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.springboot.demom04.bll.CoursService;
import fr.eni.springboot.demom04.bll.FormateurService;
import fr.eni.springboot.demom04.bo.Cours;
import fr.eni.springboot.demom04.bo.Formateur;

@Controller
@RequestMapping("/formateurs")
//Mise en session de la liste des cours
@SessionAttributes({"coursSession"})
public class FormateurController {
	
	private FormateurService formateurService;
	private CoursService coursService;
	
	@Autowired
	public FormateurController(FormateurService formateurService, CoursService coursService) {
		this.formateurService = formateurService;
		this.coursService = coursService;
	}
	
	
	@ModelAttribute("coursSession")
	public List<Cours> chargerCoursEnSession() {
		System.out.println("Chargement de la liste des cours en session");
		return coursService.getCours();
	}
	
	@ModelAttribute("formateurs")
	public List<Formateur> chargerListeFormateurs() {
		
		return formateurService.getFormateurs();
	}

	// @RequestMapping(method = RequestMethod.GET, path = "/formateurs")
	@GetMapping
	public String afficherFormateurs(Model model) {

		//List<Formateur> lstFormateurs = formateurService.getFormateurs();
		//model.addAttribute("formateurs", lstFormateurs);
		
		return "view-formateurs";
	}

	@GetMapping("/detail")
	public String detailFormateurParaParametre(
			@RequestParam(name = "email", defaultValue = "coach@eni.fr", required = false) String emailFormateur, Model model) {

		System.out.println("Le paramètre reçu = " + emailFormateur);
		
		Formateur formateur = formateurService.findByEmail(emailFormateur);
		model.addAttribute("formateur", formateur);
		

		return "view-formateur-detail";
	}

	@PostMapping("/detail")
	public String mettreAJourFormateur(@RequestParam(required = true) String nom, @RequestParam(required = true) String prenom, @RequestParam(required = true) String email, Model model) {

		System.out.println("Les paramètres :");
		System.out.println("Nom :" + nom);
		System.out.println("Prenom :" + prenom);
		System.out.println("Email : " + email);
		
		//Récupération de l'objet formateur depuis la base de données MAIS via le service formateur
		Formateur formateur = formateurService.findByEmail(email);
		//On fait nos petites mises à jour côté code
		formateur.setNom(nom);
		formateur.setPrenom(prenom);
		//Pour finir, on met à jour la DB en passant TOUJOURS par le service
		formateurService.update(formateur);
		

		//List<Formateur> lstFormateurs = formateurService.getFormateurs();
		//model.addAttribute("formateurs", lstFormateurs);
		
		return "view-formateurs";
	}
	

	//Ajouter un cours au formateur courant
	@PostMapping("/cours")
	public String ajouterCoursFormateur(@RequestParam(required = true) String email, @RequestParam(name = "idCours", required = true) long id) {		
		
		formateurService.updateCoursFormateur(email, id);
		return "redirect:/formateurs/detail?email="+email;
	}
	
	
	@GetMapping({"/detail/variable/", "/detail/variable/{email}"})
	public String detailFormateurParVariable(
			@PathVariable(name = "email"/* , required = false */) String emailFormateur) {
		
		/*
		 * if (null == emailFormateur || emailFormateur.trim().isEmpty()) {
		 * emailFormateur = "coach@eni.fr"; }
		 * System.out.println("Le variable décodée est = " + emailFormateur);
		 * 
		 * return "view-formateur-detail";
		 */
		
		return "redirect:/formateurs";
	}
	
	
}
