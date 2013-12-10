package fr.univbrest.masterdosi.dao.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univbrest.masterdosi.dao.TestDao;
import fr.univbrest.masterdosi.model.PersonneModel;

public class TestDaoImpl implements TestDao {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	
	/* (non-Javadoc)
	 * @see fr.univbrest.masterdosi.dao.impl.TestDao#creerPersonne(java.lang.String, java.lang.String)
	 */
	@Override
	public String creerPersonne(String nom, String prenom) {
		if(log.isDebugEnabled()) {
			log.debug("creerPersonne : {} {}",  nom, prenom);
		}
		return UUID.randomUUID().toString();
	}
	
	/* (non-Javadoc)
	 * @see fr.univbrest.masterdosi.dao.impl.TestDao#modifierPersonne(fr.univbrest.masterdosi.model.PersonneModel)
	 */
	@Override
	public void modifierPersonne(PersonneModel personneModel) {
		log.debug("Sortie modifierPersonne : {}" + personneModel);
	}
	
}
