package fr.eni.springboot.demom04.bo;

import java.io.Serializable;

public class Fichier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String nom;
	private String type;
	private long taille;
	private byte[] contenu;

	public Fichier() {
	}

	public Fichier(String nom, String type, long taille, byte[] contenu) {
		super();
		this.nom = nom;
		this.type = type;
		this.taille = taille;
		this.contenu = contenu;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getTaille() {
		return taille;
	}

	public void setTaille(long taille) {
		this.taille = taille;
	}
	
	

	public byte[] getContenu() {
		return contenu;
	}

	public void setContenu(byte[] contenu) {
		this.contenu = contenu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Fichier [nom=" + nom + ", type=" + type + ", taille=" + taille + "]";
	}
}
