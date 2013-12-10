package fr.univbrest.masterdosi.exception.specific;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Interface devant être implémentée par toute classe de gestion d'une exception
 * @author Pierre Le Roux
 */
public interface SpecificExceptionHandler {

	/**
	 * 
	 * @param servlet la servlet ayant reçu la requête
	 * @param request la requête ayant généré l'erreur
	 * @param e l'exception rencontrée
	 * @return la page JSP devant gérer la vue
	 */
	public String service(HttpServlet servlet, HttpServletRequest request, Exception e);
	
}
