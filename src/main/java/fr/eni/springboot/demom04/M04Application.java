package fr.eni.springboot.demom04;


import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.eni.springboot.demom04.bo.Formateur;
import fr.eni.springboot.demom04.dal.FormateurRowMapper;

@SpringBootApplication
public class M04Application {

	
	public static void main(String[] args) {
		SpringApplication.run(M04Application.class, args);
	}
}
