package fr.eni.springboot.demom04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.springboot.demom04.bll.FormateurService;
import fr.eni.springboot.demom04.bo.Formateur;

@Controller
@RequestMapping("/formateurs")
public class FormateurController {

	
	private FormateurService formateurService;
	
	@Autowired
	public FormateurController(FormateurService formateurService) {
		this.formateurService = formateurService;
	}

	// @RequestMapping(method = RequestMethod.GET, path = "/formateurs")
	@GetMapping
	public String afficherFormateurs(Model model) {

		List<Formateur> lstFormateurs = formateurService.getFormateurs();
		model.addAttribute("formateurs", lstFormateurs);
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
	public String mettreAJourFormateur(@RequestParam(required = true) Formateur formateur) {

		System.out.println("Les paramètres :");
		System.out.println("Nom :" + formateur.getNom());
		System.out.println("Prenom :" + formateur.getPrenom());
		System.out.println("Email : " + formateur.getEmail());
		
		
		return "view-formateurs";
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
