<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Usuarios registrados</h2>
	Usuario confirmado: <br/>
	Nombre: <%=request.getParameter("nombre") %> <br/><br/>
	Apellido: <%=request.getParameter("apellido") %> <br/><br/>
	
</body>
</html>