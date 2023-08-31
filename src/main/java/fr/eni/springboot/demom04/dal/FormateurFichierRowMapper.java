package fr.eni.springboot.demom04.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.eni.springboot.demom04.bo.Fichier;
import fr.eni.springboot.demom04.bo.Formateur;

public class FormateurFichierRowMapper implements RowMapper<Formateur> {

	@Override
	public Formateur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Formateur formateur = new Formateur();
		
		formateur.setEmail(rs.getString("email"));
		formateur.setNom(rs.getString("nom"));
		formateur.setPrenom(rs.getString("prenom"));
		
		//Association avec la photo
		Fichier fichier = new Fichier();
		fichier.setId(rs.getLong("id_photo"));
		fichier.setNom(rs.getString("photo"));
		formateur.setPhoto(fichier);
		
		return formateur;
	}

}
