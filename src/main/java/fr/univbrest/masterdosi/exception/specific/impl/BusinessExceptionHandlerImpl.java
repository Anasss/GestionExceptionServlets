package fr.univbrest.masterdosi.exception.specific.impl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import fr.univbrest.masterdosi.exception.specific.SpecificExceptionHandler;

public class BusinessExceptionHandlerImpl implements SpecificExceptionHandler {

	@Override
	public String service(HttpServlet servlet, HttpServletRequest request, Exception e) {
		request.setAttribute("exception", e);
		
		return "/WEB-INF/views/error_business.jsp";
	}

}
