package fr.eni.springboot.demom04.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.eni.springboot.demom04.bo.Cours;
import fr.eni.springboot.demom04.bo.Formateur;

public class FormateurRowMapper implements RowMapper<Formateur> {

	@Override
	public Formateur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Formateur formateur = new Formateur();
		
		formateur.setEmail(rs.getString("email"));
		formateur.setNom(rs.getString("lastName"));
		formateur.setPrenom(rs.getString("firstName"));
		
		//Association avec le cours principal
		Cours cours = new Cours();
		cours.setId(rs.getInt("id"));
		cours.setDuree(rs.getInt("duree"));
		cours.setTitre(rs.getString("titre"));
		
		formateur.setCoursPrincipal(cours);//Lien vers le cours princial
		
		formateur.getCours().add(cours);//Lien pour les cours du formateur
		return formateur;
	}

}
