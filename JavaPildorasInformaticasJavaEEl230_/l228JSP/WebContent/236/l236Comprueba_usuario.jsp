<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comprobación de usuario</title>
</head>
<body>


	<%
	String usuario = request.getParameter("usuario");
	String contra = request.getParameter("contra");
	
	Class.forName("com.mysql.jdbc.Driver");

	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pildinfo", "root", "secret");

	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM "+
			"usuarios WHERE usuario=? AND contrasena = ?");
	
	preparedStatement.setString(1, usuario);
	preparedStatement.setString(2, contra);
	
	ResultSet resultSet = preparedStatement.executeQuery();
	if(resultSet.absolute(1)) out.println ("Usuario autorizado");
	else out.println ("Usuario no registrado");
	
			
			
	%>

</body>
</html>