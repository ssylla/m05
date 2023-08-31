package fr.eni.springboot.demom04.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import fr.eni.springboot.demom04.bll.error.BusinessError;
import fr.eni.springboot.demom04.bll.error.BusinessException;
import fr.eni.springboot.demom04.bo.Cours;
import fr.eni.springboot.demom04.bo.Fichier;
import fr.eni.springboot.demom04.bo.Formateur;
import fr.eni.springboot.demom04.dal.CoursDAO;
import fr.eni.springboot.demom04.dal.FichierDAO;
import fr.eni.springboot.demom04.dal.FormateurDAO;

@Service
public class FormateurServiceImpl implements FormateurService {
	@Autowired
	private FormateurDAO formateurDAO;
	@Autowired
	private CoursDAO coursDAO;
	@Autowired
	private FichierDAO fichierDAO;

	@Override
	public void add(Formateur formateur) {
		BusinessException be = new BusinessException();

		boolean isValid = true;

		// Validation de mes règles métier
		isValid &= validerFormateur(formateur, be);
		isValid &= validerNom(formateur.getNom(), be);
		isValid &= validerPrenom(formateur.getPrenom(), be);
		isValid &= validerEmail(formateur.getEmail(), be);
		isValid &= validerListeCours(formateur.getCours(), be);
		isValid &= validerUniqueEmail(formateur.getEmail(), be);
		if (isValid) {
			// Création du fichier
			fichierDAO.creer(formateur.getPhoto());

			formateurDAO.create(formateur);
			// Attention, il faut aussi compléter l'appel de la méthode pour gérer
			// l'insertion en base des cours
			formateur.getCours().forEach(c -> {
				coursDAO.insertCoursFormateur(c.getId(), formateur.getEmail());
			});

		} else {
			throw be;
		}
	}

	@Override
	public List<Formateur> getFormateurs() {
		return formateurDAO.findAll();
	}

	@Override
	public Formateur findByEmail(String emailFormateur) {
		return formateurDAO.read(emailFormateur);
	}

	public void update(Formateur formateur) {
		formateurDAO.update(formateur);
	}

	@Override
	public void updateCoursFormateur(String emailFormateur, long idCours) {
		// Mise à jour au niveau BO
		Formateur f = formateurDAO.read(emailFormateur);
		Cours c = coursDAO.read(idCours);
		f.getCours().add(c);

		// Mise à jour en base
		coursDAO.insertCoursFormateur(idCours, emailFormateur);
	}

	public Fichier getFormateurPhoto(long photoId) {

		
		return fichierDAO.lire(photoId);
	}

	private boolean validerFormateur(Formateur formateur, BusinessException be) {
		boolean resultat = true;
		if (null == formateur) {
			be.add(BusinessError.VALIDATION_FORMATEUR_NULL);
			resultat = false;
		}
		return resultat;
	}

	private boolean validerNom(String nom, BusinessException be) {
		boolean resultat = true;
		if (null == nom || nom.isBlank()) {
			be.add(BusinessError.VALIDATION_FORMATEUR_NOM_BLANK);
			resultat = false;
		}

		if (null != nom && (nom.length() < 2 || nom.length() > 250)) {
			be.add(BusinessError.VALIDATION_FORMATEUR_NOM_LENGTH);
			resultat = false;
		}
		return resultat;
	}

	private boolean validerPrenom(String prenom, BusinessException be) {
		if (prenom == null || prenom.isBlank()) {
			be.add(BusinessError.VALIDATION_FORMATEUR_PRENOM_BLANK);
			return false;
		}
		if (prenom.length() < 4 || prenom.length() > 250) {
			be.add(BusinessError.VALIDATION_FORMATEUR_PRENOM_LENGTH);
			return false;
		}
		return true;
	}

	private boolean validerEmail(String email, BusinessException be) {
		if (email == null || email.isBlank()) {
			be.add(BusinessError.VALIDATION_FORMATEUR_EMAIL_BLANK);
			return false;
		}
		// Regex to check valid email
		String regex = "^[\\w-\\.]+@campus-eni.fr$";

		if (!email.matches(regex)) {
			be.add(BusinessError.VALIDATION_FORMATEUR_EMAIL_PATTERN);
			return false;
		}
		return true;
	}

	private boolean validerListeCours(List<Cours> lstCours, BusinessException be) {
		if (lstCours == null || lstCours.isEmpty()) {
			be.add(BusinessError.VALIDATION_FORMATEUR_COURS_EMPTY);
			return false;
		}

		// Vérifier que chaque identifiant de cours existe en base :
		if (!coursDAO.validateListOfCourseIds(lstCours)) {
			be.add(BusinessError.VALIDATION_FORMATEUR_COURS_ID_INCONNU);
			return false;
		}

		return true;
	}

	private boolean validerUniqueEmail(String email, BusinessException be) {
		int count = formateurDAO.uniqueEmail(email);
		if (count == 1) {
			be.add(BusinessError.VALIDATION_FORMATEUR_UNIQUE_EMAIL);
			return false;
		}
		return true;
	}

	private boolean validerEmailExiste(String emailFormateur, BusinessException be) {
		// L'email doit exister - s'il n'existe pas il y aura levée de l'exception
		// DataAccessException
		// Il faut gérer les 2 cas
		try {
			Formateur f = formateurDAO.read(emailFormateur);
			if (f == null) {
				// Il n'y a pas de formateur correspondant en base
				be.add(BusinessError.VALIDATION_FORMATEUR_DB_NULL);
				return false;
			}
		} catch (DataAccessException e) {
			// Impossible de trouver un formateur
			// Il n'y a pas de formateur correspondant en base
			be.add(BusinessError.VALIDATION_FORMATEUR_DB_NULL);
			return false;
		}
		return true;
	}

}
