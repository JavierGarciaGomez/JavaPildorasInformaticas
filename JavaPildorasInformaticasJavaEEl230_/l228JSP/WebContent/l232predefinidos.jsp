<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Objetos predefinidos JSP</h2>
	<p>
		Petición datos del navegador
		<%=request.getHeader("User-Agent")%></p>
	<p>
		Petición datos del idioma
		<%=request.getLocale()%>
	</p>

</body>
</html>