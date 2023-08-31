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

	private static final String INSERT_QUERY = "INSERT INTO `formateur` (email, nom, prenom, id_photo) VALUES (:email,:nom,:prenom,:idPhoto)";
	private static final String FIND_BY_EMAIL_QUERY = "SELECT fo.email, fo.nom, fo.prenom, fo.id_photo, fi.nom as photo FROM `formateur` fo LEFT JOIN `fichier` fi ON fo.id_photo = fi.id WHERE email = :email";
	private static final String FIND_ALL_QUERY = "SELECT fo.email, fo.nom, fo.prenom, fo.id_photo, fi.nom as photo FROM `formateur` fo LEFT JOIN `fichier` fi ON fo.id_photo = fi.id";
	private static final String UPDATE_QUERY = "UPDATE `formateur` SET nom = :nom, prenom = :prenom WHERE email = :email";
	private final String COUNT_EMAIL_QUERY = "SELECT count(email) FROM `formateur` WHERE email = :email";

	@Autowired
	private NamedParameterJdbcTemplate njt;

	@Override
	public void create(Formateur formateur) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("nom", formateur.getNom());
		mapParameters.addValue("email", formateur.getEmail());
		mapParameters.addValue("prenom", formateur.getPrenom());
		mapParameters.addValue("idPhoto", formateur.getPhoto().getId());

		njt.update(INSERT_QUERY, mapParameters);
	}

	@Override
	public Formateur read(String emailFormateur) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("email", emailFormateur);
		return njt.queryForObject(FIND_BY_EMAIL_QUERY, mapParameters, new FormateurFichierRowMapper());
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
		return njt.query(FIND_ALL_QUERY, new FormateurFichierRowMapper());
	}

	@Override
	public int uniqueEmail(String email) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("email", email);
		return njt.queryForObject(COUNT_EMAIL_QUERY, namedParameters, Integer.class);
	}

}
