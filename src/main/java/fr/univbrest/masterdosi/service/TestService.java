package fr.univbrest.masterdosi.service;

import fr.univbrest.masterdosi.model.PersonneModel;

public interface TestService {

	public abstract PersonneModel creerOuModifierPersonnePhysique(
			PersonneModel personneModel);

}