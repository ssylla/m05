package fr.eni.springboot.demom04;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class M04Application implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jt;
	
	private static final String DROP_FORMATEUR_TABLE_QUERY = "DROP TABLE IF EXISTS `formateur`";
	private static final String CREATE_FORMATEUR_TABLE_QUERY = "CREATE TABLE `formateur` (\r\n"
			+ "	`email` VARCHAR(200) NOT NULL,\r\n"
			+ "	`nom` VARCHAR(250) NULL DEFAULT NULL,\r\n"
			+ "	`prenom` VARCHAR(250) NULL DEFAULT NULL,\r\n"
			+ "	PRIMARY KEY (`email`)\r\n"
			+ ")";
	
	private static final String INSERT_FORMATEUR_QUERY = "INSERT INTO FORMATEUR (email, nom, prenom) VALUES ('abaille@campus-eni.fr','BAILLE','Anne-Lise')";
	private static final String COUNT_FORMATEUR_QUERY = "SELECT count(*) FROM FORMATEUR";
	private static final String FIND_EMAILS_FORMATEURS = "SELECT email FROM FORMATEUR";
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(M04Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("************************************");
		System.out.println("**************Welcome***************");
		System.out.println("************************************");
		//Création de la table formateur
		creerTableFormateur();
		
		//Insertion de Anne-Lise
		System.out.println("Le nombre de formateurs ajoutés : "+ ajoutFormateurs());
		
		//Récupération du nombre de formateurs
		System.out.println("Le nombre total de formateurs dans ma base est : "+ getNbFormateurs());
		
		//Récupération des emails de l'ensemble des formateurs
		System.out.println("Liste des emails" + getFormateursEmails());
		
		//Récupération d'une liste de formateurs correctement initialisée par Spring      	
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
}
