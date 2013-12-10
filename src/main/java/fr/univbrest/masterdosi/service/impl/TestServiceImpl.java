package fr.univbrest.masterdosi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univbrest.masterdosi.dao.TestDao;
import fr.univbrest.masterdosi.dao.impl.TestDaoImpl;
import fr.univbrest.masterdosi.exception.UnauthorizedUserException;
import fr.univbrest.masterdosi.model.PersonneModel;
import fr.univbrest.masterdosi.service.TestService;

public class TestServiceImpl implements TestService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private TestDao testDao;
	
	
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	
	public TestServiceImpl() {
		/* TODO ETAPE1 Remplacer la création de testDao dans le contructeur via l'injection d'une dépendance par le setter ci-dessus */
		testDao = new TestDaoImpl();
	}
	
	/* (non-Javadoc)
	 * @see fr.univbrest.masterdosi.service.TestService#creerOuModifierPersonnePhysique(fr.univbrest.masterdosi.model.PersonneModel)
	 */
	@Override
	public PersonneModel creerOuModifierPersonnePhysique(PersonneModel personneModel) {
		if(log.isDebugEnabled()) {
			log.debug("Entrée creerOuModifierPersonnePhysique : {}" , personneModel);
		}
		
		if(personneModel.getNom().equalsIgnoreCase("erreur")) {
			throw new UnauthorizedUserException("Le user erreur n'est pas autorisé");
		}
		
		
		if(personneModel.getId() != null && personneModel.getId().trim().length() > 0 ) {
			testDao.modifierPersonne(personneModel);
		}
		else {
			personneModel.setId(testDao.creerPersonne(personneModel.getNom(), personneModel.getPrenom()));
			log.info("Personne créée {}", personneModel.getId());
		}
		
		if(log.isDebugEnabled()) {
			log.debug("Sortie creerOuModifierPersonnePhysique : {}" , personneModel);
		}
		
		return personneModel;
		
	}
	
}
