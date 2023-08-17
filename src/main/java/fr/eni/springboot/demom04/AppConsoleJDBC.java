package fr.eni.springboot.demom04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.eni.springboot.demom04.bo.Formateur;
import fr.eni.springboot.demom04.dal.FormateurRowMapper;

public class AppConsoleJDBC {

	
	@Autowired
	private JdbcTemplate jt;
	
	@Autowired
	private NamedParameterJdbcTemplate njt;
	
	private static final String DROP_FORMATEUR_TABLE_QUERY = "DROP TABLE IF EXISTS `formateur`";
	private static final String CREATE_FORMATEUR_TABLE_QUERY = "CREATE TABLE `formateur` (\r\n"
			+ "	`email` VARCHAR(200) NOT NULL,\r\n"
			+ "	`nom` VARCHAR(250) NULL DEFAULT NULL,\r\n"
			+ "	`prenom` VARCHAR(250) NULL DEFAULT NULL,\r\n"
			+ "	PRIMARY KEY (`email`)\r\n"
			+ ")";
	
	private static final String INSERT_FORMATEUR_QUERY = "INSERT INTO `formateur` (email, nom, prenom) VALUES ('abaille@campus-eni.fr','BAILLE','Anne-Lise')";
	private static final String COUNT_FORMATEUR_QUERY = "SELECT count(*) FROM `formateur`";
	private static final String FIND_EMAILS_FORMATEURS = "SELECT email FROM `formateur`";
	private static final String FIND_ALL_FORMATEURS_QUERY = "SELECT email, nom, prenom FROM `formateur`";
	private static final String FIND_ALL_FORMATEURS_COURS_QUERY = "SELECT f.email AS email, f.nom AS lastName, f.prenom AS firstName, c.* FROM `formateur` f INNER JOIN `cours_eni` c ON f.id_cours_principal = c.id";
	//Requête de création de formateur avec des paramètres
	private static final String INSERT_FORMATEUR_AVEC_PARAMS = "INSERT INTO `formateur` (email, nom, prenom) VALUES ('%s','%s','%s')";
	

	//Requête d'authentifications 
	private static final String LOGIN_NON_SECURE = "SELECT login FROM `utilisateur` WHERE login = '%s' AND mdp = '%s'";
	private static final String LOGIN_SECURE = "SELECT login FROM `utilisateur` WHERE login = ? AND mdp = ?";
	private static final String LOGIN_SECURE_NOMME = "SELECT login FROM `utilisateur` WHERE login = :identifiant AND mdp = :pwd";
	
	
	public void run(String... args) throws Exception {

		System.out.println("************************************");
		System.out.println("**************Welcome***************");
		System.out.println("************************************");
		//Création de la table formateur
		//creerTableFormateur();
		
		//Insertion de Anne-Lise
		//System.out.println("Le nombre de formateurs ajoutés : "+ ajoutFormateurs());
		
		//Récupération du nombre de formateurs
		System.out.println("Le nombre total de formateurs dans ma base est : "+ getNbFormateurs());
		
		//Récupération des emails de l'ensemble des formateurs
		System.out.println("Liste des emails" + getFormateursEmails());
		
		//Récupération d'une liste de formateurs correctement initialisée par Spring 
		System.out.println("Liste des formateurs : " + getFormateurs()); 
		

		//Récupération d'une liste de formateurs correctement initialisée par Spring 
		System.out.println("Liste des formateurs en utlisant un rowMapper : " + getFormateursAvecRowMapper()); 
		
		
		//Ajout d'un nouveau formateur variable
		//System.out.println("On ajoute Manu : "+ creerFormateur("manu4@campus-eni.fr", "Malabry", "Manu"));
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenue dans mon outils");
		System.out.println("Merci de vous identifier...");

		System.out.print("Login : ");
		String login = sc.nextLine();
		System.out.print("Mot de passe : ");
		String mdp = sc.nextLine();
		
		String userLogin = login(login, mdp);
		if (null != userLogin) {
			System.out.printf("Bienvenue à toi (non securisé) %s%n", userLogin);
		} else {
			System.out.println("Erreur d'identification (non securisé)");
		}
		
		String userLoginSecurise = loginSecurise(login, mdp);
		if (null != userLoginSecurise) {
			System.out.printf("Bienvenue à toi (securisé) %s%n", userLogin);
		} else {
			System.out.println("Erreur d'identification (securisé)");
		}
	}
	
	private void creerTableFormateur() {
		
		jt.execute(DROP_FORMATEUR_TABLE_QUERY);
		jt.execute(CREATE_FORMATEUR_TABLE_QUERY);
	}
	
	private int ajoutFormateurs() {
		
		return jt.update(INSERT_FORMATEUR_QUERY);
	}
	
	private int getNbFormateurs() {
		return jt.queryForObject(COUNT_FORMATEUR_QUERY, Integer.class);
	}

	private List<String> getFormateursEmails() {
		return jt.queryForList(FIND_EMAILS_FORMATEURS, String.class);
	}
	
	private List<Formateur> getFormateurs() {
		
		return jt.query(FIND_ALL_FORMATEURS_QUERY, new BeanPropertyRowMapper<>(Formateur.class));
	}
	
	private List<Formateur> getFormateursAvecRowMapper() {
		
		return jt.query(FIND_ALL_FORMATEURS_COURS_QUERY, new FormateurRowMapper());
	}
	
	private int creerFormateur(String email, String nom, String prenom) {
		
		return jt.update(String.format(INSERT_FORMATEUR_AVEC_PARAMS, email, nom, prenom));
	}

	private String login(String login, String motDePasse) {
		
		return jt.queryForObject(String.format(LOGIN_NON_SECURE, login, motDePasse), String.class);
	}
	private String loginSecurise(String login, String motDePasse) {
		
		return jt.queryForObject(LOGIN_SECURE, String.class, login, motDePasse);
	}
	private String loginSecuriseNomme(String login, String motDePasse) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("identifiant", login);
		namedParameters.addValue("pwd", motDePasse);
		
		return njt.queryForObject(LOGIN_SECURE, namedParameters, String.class);
	}
}
