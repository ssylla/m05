package fr.eni.springboot.demom04.dal;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.springboot.demom04.bo.Fichier;

@Repository
public class FichierDAOImpl implements FichierDAO {

	private static final String FIND_BY_ID_QUERY = "SELECT id, nom, type, taille, contenu FROM `fichier` WHERE id = :id";
	private static final String INSERT_QUERY = "INSERT INTO `fichier` (nom, type, taille, contenu) VALUES (:nom, :type, :taille, :contenu)";
	private static final String UPDATE_QUERY = "UPDATE `fichier` SET nom = :nom, type = :type, taille = :taille, contenu = :contenu WHERE id = :id";

	@Autowired
	NamedParameterJdbcTemplate njt;

	@Override
	public void creer(Fichier fichier) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("nom", fichier.getNom());
		mapParameters.addValue("type", fichier.getType());
		mapParameters.addValue("taille", fichier.getTaille());
		mapParameters.addValue("contenu", new ByteArrayInputStream(fichier.getContenu()));

		KeyHolder keyHolder = new GeneratedKeyHolder();
		njt.update(INSERT_QUERY, mapParameters, keyHolder);
		fichier.setId(keyHolder.getKey().longValue());
	}

	@Override
	public void modifier(Fichier fichier) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("nom", fichier.getNom());
		mapParameters.addValue("type", fichier.getType());
		mapParameters.addValue("taille", fichier.getTaille());
		mapParameters.addValue("contenu", new ByteArrayInputStream(fichier.getContenu()));
		mapParameters.addValue("id", fichier.getId());

		njt.update(UPDATE_QUERY, mapParameters);
	}

	@Override
	public Fichier lire(long id) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("id", id);

		return njt.queryForObject(FIND_BY_ID_QUERY, mapParameters, new BeanPropertyRowMapper<>(Fichier.class));
	}
}
