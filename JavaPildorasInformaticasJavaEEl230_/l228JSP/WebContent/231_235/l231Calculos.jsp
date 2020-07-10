<%@page import="jsp.com.calculos.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Cálculos varios</h1>
	<p> La SUMA de 8 y 10 es igual a: <%= calculos.metodoSuma(8,5) %>
	<p> La RESTA de 8 y 10 es igual a: <%= calculos.metodoResta(8, 10) %>
	
</body>
</html>