package fr.univbrest.masterdosi.dao;

import fr.univbrest.masterdosi.model.PersonneModel;

public interface TestDao {

	public abstract String creerPersonne(String nom, String prenom);

	public abstract void modifierPersonne(PersonneModel personneModel);

}