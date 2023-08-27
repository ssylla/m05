package fr.eni.springboot.demom04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import fr.eni.springboot.demom04.bll.CoursService;
import fr.eni.springboot.demom04.bll.FormateurService;
import fr.eni.springboot.demom04.bll.error.BusinessException;
import fr.eni.springboot.demom04.bo.Cours;
import fr.eni.springboot.demom04.bo.Formateur;
import jakarta.validation.Valid;

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

	@GetMapping("/creer")
	public String creerFormateur(Model model) {
		
		model.addAttribute("formateur", new Formateur());
		return "view-formateur-creer";
	}
	

	@PostMapping("/creer")
	public String creerFormateur(@Valid @ModelAttribute("formateur") Formateur formateur, BindingResult bindingResult)  {

		if (bindingResult.hasErrors()) {
			return "view-formateur-creer";
		} else {
			try {
				formateurService.add(formateur);
				return "redirect:/formateurs";
			} catch (BusinessException be) {
				be.getErrors().forEach(errorItem -> {
					ObjectError error = new ObjectError("globalErrors", errorItem.getMessageKey());
					bindingResult.addError(error);
				});				
				return "view-formateur-creer";
			}			
		}
	}
	
	
	@GetMapping("/detail")
	public String detailFormateurParParametre(
			@RequestParam(name = "email", defaultValue = "coach@eni.fr", required = false) String emailFormateur, Model model) {

		System.out.println("Le paramètre reçu = " + emailFormateur);
		
		Formateur formateur = formateurService.findByEmail(emailFormateur);
		model.addAttribute("formateur", formateur);
		

		return "view-formateur-detail";
	}

	@PostMapping("/detail")
	public String mettreAJourFormateur(@Valid @ModelAttribute Formateur formateur, BindingResult bindingResult) {

		System.out.println("Les données du formateur récupérées depuis le formulaire :");
		System.out.println("Nom :" + formateur.getNom());
		System.out.println("Prenom :" + formateur.getPrenom());
		System.out.println("Email : " + formateur.getEmail());
		System.out.println("Photo : " + formateur.getPhoto());
		
		if (bindingResult.hasErrors()) {
			return "view-formateur-detail";
		} else {
			//Récupération de l'objet formateur depuis la base de données MAIS via le service formateur
			//Formateur formateur = formateurService.findByEmail(email);
			//On fait nos petites mises à jour côté code
			//formateur.setNom(nom);
			//formateur.setPrenom(prenom);
			//Pour finir, on met à jour la DB en passant TOUJOURS par le service
			formateurService.update(formateur);
			
			//List<Formateur> lstFormateurs = formateurService.getFormateurs();
			//model.addAttribute("formateurs", lstFormateurs);
			
			return "redirect:/formateurs";	
		}
		
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
