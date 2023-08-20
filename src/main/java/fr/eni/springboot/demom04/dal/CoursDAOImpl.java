package fr.eni.springboot.demom04.dal;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.springboot.demom04.bo.Cours;

@Repository
@Profile("prod")
public class CoursDAOImpl implements CoursDAO {

	private static final String FIND_BY_ID = "SELECT id, titre, duree FROM `cours_eni` WHERE id = :id";
	private static final String FIND_ALL = "SELECT id, titre, duree FROM `cours_eni`";
	private static final String FIND_BY_FORMATEUR = "SELECT id, titre, duree FROM `cours_eni` c "
			+ "INNER JOIN `cours_formateur` cf ON c.id = cf.id_cours WHERE cf.email_formateur = :email";
	private static final String INSERT_COURS_FORMATEUR = "INSERT INTO `cours_formateur` (email_formateur, id_cours) VALUES (:email, :idCours)";
	private final String COUNT_ID_IN_LIST_QUERY = "select count(id) from `cours_eni` where id in (:lst_id_cours)";
	
	@Autowired
	NamedParameterJdbcTemplate njt;
	
	@Override
	public Cours read(long id) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("id", id);
		
		return njt.queryForObject(FIND_BY_ID, mapParameters, new BeanPropertyRowMapper<>(Cours.class));
	}

	@Override
	public List<Cours> findAll() {
		
		return njt.query(FIND_ALL, new BeanPropertyRowMapper<>(Cours.class));
	}

	@Override
	public List<Cours> findByFormateur(String emailFormateur) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("email", emailFormateur);
		return njt.query(FIND_BY_FORMATEUR, mapParameters, new BeanPropertyRowMapper<>(Cours.class));
	}

	@Override
	public void insertCoursFormateur(long idCours, String emailFormateur) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("email", emailFormateur);
		mapParameters.addValue("idCours", idCours);
		
		njt.update(INSERT_COURS_FORMATEUR, mapParameters);
	}
	
	@Override
	public boolean validateListOfCourseIds(List<Cours> lstCours) {
		// Liste des identifiants des cours
		List<Long> lstId = lstCours.stream().map(Cours::getId).collect(Collectors.toList());

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("lst_id_cours", lstId);

		int nbIds = njt.queryForObject(COUNT_ID_IN_LIST_QUERY, namedParameters, Integer.class);

		return lstId.size() == nbIds;
	}
}
