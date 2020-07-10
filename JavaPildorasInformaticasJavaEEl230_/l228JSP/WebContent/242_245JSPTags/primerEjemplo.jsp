<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
    	String alumnos[]={"Antonio", "Sandra", "Maria", "Paco"};
    	pageContext.setAttribute("losAlumnos", alumnos);
    %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4> Ejemplo con jsp </h4>
<%
	// using jdbc
	for(String tempAlumno:alumnos){
		out.print(tempAlumno+"<br>");
	}
%>

<h4> Ejemplo con tags </h4>

<c:forEach var="temp" items="${losAlumnos}">

	${temp} <br>
	
</c:forEach>



</body>
</html>