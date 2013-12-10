package fr.univbrest.masterdosi.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univbrest.masterdosi.exception.specific.SpecificExceptionHandler;
import fr.univbrest.masterdosi.exception.specific.impl.BusinessExceptionHandlerImpl;

/**
 * Permet de gérer de façon centralisée les exceptions remontées par les couches services...
 * et déterminer quel {@link SpecificExceptionHandler} doit prendre en charge l'exception
 * @author Pierre Le Roux
 *
 */
public class ExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private Map<Class, SpecificExceptionHandler> mapping;
	
	public ExceptionHandler() {
		mapping = new LinkedHashMap<Class, SpecificExceptionHandler>();
		populateExceptionHandlers();
	}
	
	/**
	 * Permet de gérer de façon centrale toutes les exceptions remontées. 
	 * A partir d'une exception, on recherche dans un mapping puis au premier match de l'exception avec un type référencé, 
	 * on retourne le gestionnaire spécifique de l'exception {@link SpecificExceptionHandler}
	 * @param e l'exception à gérer
	 * @return le gestionnaire associé à cette exception ou null si aucun gestionnaire n'est associé
	 */
	public SpecificExceptionHandler delegateExceptionManagement(Exception e) {
		
		log.error("Une exception a été remontée", e);
		for (Map.Entry<Class, SpecificExceptionHandler> exceptionMapping : mapping.entrySet()) {
			if(exceptionMapping.getKey().isInstance(e)) {
				return exceptionMapping.getValue();
			}
		}
		return null;
	}
	
	

	private void populateExceptionHandlers() {
		SpecificExceptionHandler businessExceptionExceptionHandler = new BusinessExceptionHandlerImpl();
		mapping.put(UnauthorizedUserException.class, businessExceptionExceptionHandler);
		mapping.put(Exception.class, businessExceptionExceptionHandler);
		// Ajouter tout nouveau type d'exception ici
	}
	
	
}
