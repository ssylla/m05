package fr.eni.springboot.demom04.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cours implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String titre;
	private int duree;
	
	private List<Formateur> formateurs;
	
	{
		formateurs = new ArrayList<>();
	}
	
	public Cours() {
		this(0, "", 0);
	}

	
	public Cours(String titre, int duree) {
		this(0, titre, duree);
	}

	public Cours(long id, String titre, int duree) {
		this.id = id;
		this.titre = titre;
		this.duree = duree;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}

	

	public List<Formateur> getFormateurs() {
		return formateurs;
	}


	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}


	@Override
	public String toString() {
		return "Cours [id=" + id + ", titre=" + titre + ", duree=" + duree + "]";
	}

}
