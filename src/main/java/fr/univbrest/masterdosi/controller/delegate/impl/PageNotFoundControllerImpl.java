package fr.univbrest.masterdosi.controller.delegate.impl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import fr.univbrest.masterdosi.controller.delegate.DosiController;

public class PageNotFoundControllerImpl implements DosiController {
	
	@Override
	public String service(HttpServlet servlet, HttpServletRequest request) {
		return "/WEB-INF/views/404.jsp";
	}

}
