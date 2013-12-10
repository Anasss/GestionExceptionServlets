package fr.univbrest.masterdosi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univbrest.masterdosi.controller.delegate.DosiController;
import fr.univbrest.masterdosi.controller.delegate.impl.IndexControllerImpl;
import fr.univbrest.masterdosi.controller.delegate.impl.PageNotFoundControllerImpl;
import fr.univbrest.masterdosi.controller.delegate.impl.PostUserControllerImpl;
import fr.univbrest.masterdosi.controller.delegate.impl.UserControllerImpl;
import fr.univbrest.masterdosi.exception.ExceptionHandler;
import fr.univbrest.masterdosi.exception.specific.SpecificExceptionHandler;


public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private Map<String, DosiController> mapping;
	private DosiController pageNotFoundController;

	private ExceptionHandler exceptionHandler;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
        populateMapping(config);
        exceptionHandler = new ExceptionHandler();
        pageNotFoundController = new PageNotFoundControllerImpl();
	}
	
	
	
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();	
		String dispatch;
		try {
			DosiController delegate = mapping.get(uri);
			if (delegate != null) {
				dispatch = delegate.service(this, request);
			}
			else {
				dispatch = pageNotFoundController.service(this, request);
			}
		}
		catch(Exception e) {
			SpecificExceptionHandler specificExceptionHandler = exceptionHandler.delegateExceptionManagement(e);
			dispatch = specificExceptionHandler.service(this, request, e);
		}
		
		getServletContext().getRequestDispatcher(dispatch).forward(request,
				response);
	}
	


	private void populateMapping(ServletConfig config) {
		
		mapping = new HashMap<String, DosiController>();
		String contextPath = config.getServletContext().getContextPath();
		mapping.put(contextPath + "/", new IndexControllerImpl());
		mapping.put(contextPath + "/user", new UserControllerImpl());
		mapping.put(contextPath + "/postuser", new PostUserControllerImpl());
	}


}
