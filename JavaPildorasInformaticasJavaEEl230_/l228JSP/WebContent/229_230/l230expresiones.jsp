<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Ejemplo de expresiones</h1>
	Convirtiendo a mayúsculas <%= new  String("javier").toUpperCase() %>
	<br>
	La suma de 5 y 7 es : <%= 5+7 %>
	<br>
	10 es mayor que 100: <%= 10>100 %>
	
	
	<h1>Ejemplo de Scriplet</h1>
	<%
		for(int i=0; i<10; i++){
			out.println("<br>Este es el mensaje "+i);
		}
		out.println("<br><br> acabe de imprimir");
	%>
	
		<h1>Ejemplo de declaraciones</h1>
	<%!
		private int resultado;
	
		public int metodoSuma(int num1, int num2){
			return num1+num2;
		}
		
		public int metodoResta(int num1, int num2){
			return num1-num2;
		}
	%>
	
	<p> Ahora voy a probar expresiones con nums 9 y 5. </p>
	<p> La suma es igual a: <%= metodoSuma(9, 5) %> </p>
	<p> La resta es igual a: <%= metodoResta(9, 5) %> </p> 
	
	
	
</body>
</html>