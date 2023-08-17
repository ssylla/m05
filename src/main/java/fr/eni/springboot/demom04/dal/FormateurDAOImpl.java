package fr.eni.springboot.demom04.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.springboot.demom04.bo.Formateur;

@Repository
@Profile("prod")
public class FormateurDAOImpl implements FormateurDAO {

	private static final String INSERT_QUERY = "INSERT INTO `formateur` (email, nom, prenom) VALUES (:email,:nom,:prenom)";
	private static final String FIND_BY_EMAIL_QUERY = "SELECT email, nom, prenom FROM `formateur` WHERE email = :email";
	private static final String FIND_ALL_QUERY = "SELECT email, nom, prenom FROM `formateur`";
	private static final String UPDATE_QUERY = "UPDATE `formateur` SET nom = :nom, prenom = :prenom WHERE email = :email";

	@Autowired
	private NamedParameterJdbcTemplate njt;

	@Override
	public void create(Formateur formateur) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("nom", formateur.getNom());
		mapParameters.addValue("email", formateur.getEmail());
		mapParameters.addValue("prenom", formateur.getPrenom());

		njt.update(INSERT_QUERY, mapParameters);
	}

	@Override
	public Formateur read(String emailFormateur) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("email", emailFormateur);
		return njt.queryForObject(FIND_BY_EMAIL_QUERY, mapParameters, new BeanPropertyRowMapper<>(Formateur.class));
	}

	@Override
	public void update(Formateur formateur) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("nom", formateur.getNom());
		mapParameters.addValue("email", formateur.getEmail());
		mapParameters.addValue("prenom", formateur.getPrenom());
		njt.update(UPDATE_QUERY, mapParameters);
	}

	@Override
	public List<Formateur> findAll() {
		return njt.query(FIND_ALL_QUERY, new BeanPropertyRowMapper<>(Formateur.class));
	}
}
