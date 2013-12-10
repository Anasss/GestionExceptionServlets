package fr.univbrest.masterdosi.controller.delegate.impl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univbrest.masterdosi.controller.delegate.DosiController;
import fr.univbrest.masterdosi.model.PersonneModel;
import fr.univbrest.masterdosi.service.TestService;
import fr.univbrest.masterdosi.service.impl.TestServiceImpl;
import fr.univbrest.masterdosi.spring.ApplicationContextProvider;

public class PostUserControllerImpl implements DosiController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private TestService testService;
	

	
	public PostUserControllerImpl() {
		testService = new TestServiceImpl();
		// TODO ETAPE1 Charger le singleton testService déclaré dans basicservlet-context.xml à partir du contexte Spring
		// testService = ApplicationContextProvider.getApplicationContext().getBean("testService", TestService.class);
	}
	
	
	@Override
	public String service(HttpServlet servlet, HttpServletRequest request) {
		log.debug( request.getParameter("nom"));
		
		
		
		PersonneModel personneModel = new PersonneModel();
		personneModel.setId(request.getParameter("id"));
		personneModel.setNom(request.getParameter("nom"));
		personneModel.setPrenom(request.getParameter("prenom"));
		
		
		request.setAttribute("nom", request.getParameter("nom"));
		request.setAttribute("prenom", request.getParameter("prenom"));
		personneModel = testService.creerOuModifierPersonnePhysique(personneModel);
		request.setAttribute("id", personneModel.getId());
		request.setAttribute("personne", personneModel);
		request.setAttribute("message", "L'action sur la personne a bien été traitée");
		return "/WEB-INF/views/user.jsp";

	}

}
