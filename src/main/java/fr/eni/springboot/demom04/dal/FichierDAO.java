package fr.eni.springboot.demom04.dal;

import fr.eni.springboot.demom04.bo.Fichier;

public interface FichierDAO {

	public void creer(Fichier fichier);
	public void modifier(Fichier fichier);
	public Fichier lire(long id);
}
