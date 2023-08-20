package fr.eni.springboot.demom04.bll.error;

public enum BusinessError {

	// Comme dans pas mal de librairie, il peut être intéressant de codifier (voire
	// catégoriser warn, error, ...) les erreurs métier, en plus de leur message
	// descriptif
	VALIDATION_FORMATEUR_NULL(1, "validation.formateur.null", "Warn"),
	VALIDATION_FORMATEUR_NOM_BLANK(2, "validation.formateur.nom.blank", "Warn"),
	VALIDATION_FORMATEUR_NOM_LENGTH(3, "validation.formateur.nom.length", "Warn"),
	VALIDATION_FORMATEUR_PRENOM_BLANK(4, "validation.formateur.prenom.blank", "Warn"),
	VALIDATION_FORMATEUR_PRENOM_LENGTH(5, "validation.formateur.prenom.length", "Warn"),
	VALIDATION_FORMATEUR_EMAIL_BLANK(6, "validation.formateur.email.blank", "Warn"),
	VALIDATION_FORMATEUR_EMAIL_PATTERN(7, "validation.formateur.email.pattern", "Warn"),
	VALIDATION_FORMATEUR_COURS_EMPTY(8, "validation.formateur.cours.empty", "Warn"),
	VALIDATION_FORMATEUR_COURS_ID_INCONNU(9, "validation.formateur.cours.id.inconnu", "Warn"),
	VALIDATION_FORMATEUR_UNIQUE_EMAIL(10, "validation.formateur.unique.email", "Warn"),
	VALIDATION_FORMATEUR_DB_NULL(11, "validation.formateur.db.null", "Warn"),
	BLL_FORMATEUR_UPDATE_ERREUR(12, "bll.formateur.update.erreur", "Warn"),
	VALIDATION_FORMATEUR_DS_ERROR(555, "bll.formateur.update.erreur", "Warn");

	private int code;
	private String messageKey;
	private String level;

	private BusinessError(int code, String messageKey, String level) {
		this.code = code;
		this.messageKey = messageKey;
		this.level = level;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String toString() {
		return messageKey;
	}
}
