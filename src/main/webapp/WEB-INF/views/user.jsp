<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de personnes</title>
</head>
<body>
	
	<form action="<%=request.getContextPath()%>/postuser" method="post">
	    Id : <b>${id}</b><br/>
	    Nom : <input type="text" name="nom" size="10" value="${personne.nom}"/><br/>
	    Prénom : <input type="text" name="prenom" size="10" value="${personne.prenom}"/>
	    <input type="hidden" name="id" value="${personne.id}"/><br/>
		<input type="Submit"value="Valider">
	</form>

</body>
</html>