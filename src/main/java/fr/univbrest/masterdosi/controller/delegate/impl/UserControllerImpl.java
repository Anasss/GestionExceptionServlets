package fr.univbrest.masterdosi.controller.delegate.impl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import fr.univbrest.masterdosi.controller.delegate.DosiController;

public class UserControllerImpl implements DosiController {
	
	@Override
	public String service(HttpServlet servlet, HttpServletRequest request) {
		return "/WEB-INF/views/user.jsp";
	}

}
