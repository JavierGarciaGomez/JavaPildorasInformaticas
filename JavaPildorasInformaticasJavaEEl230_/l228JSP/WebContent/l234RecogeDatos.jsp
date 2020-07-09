<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String usuario = request.getParameter("usuario");
	String contra = request.getParameter("contra");
	String pais = request.getParameter("pais");
	String tecnologias = request.getParameter("tecnologias");
	
	Class.forName("com.mysql.jdbc.Driver");

	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pildinfo", "root", "secret");

	String insert = "INSERT INTO usuarios (nombre, apellido, usuario, contrasena, pais, tecnologia) " + "VALUES('" + nombre
			+ "','" + apellido + "','" + usuario + "','" + contra + "','" + pais + "','" + tecnologias + "')";

	Statement statement = connection.createStatement();
	statement.executeUpdate(insert);
	%>




</body>
</html>