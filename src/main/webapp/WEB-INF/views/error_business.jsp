<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de personnes</title>
</head>
<body>
	L'erreur métier suivante a été rencontrée : <br/>
	<%
		Exception e = (Exception)request.getAttribute("exception");
		if(e != null) {
			out.println(e.getMessage());
		}
		else {
			out.println("Aucune exception remontée.");
		}
	
	%>

</body>
</html>