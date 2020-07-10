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
	// Valor por defecto
	String ciudad_favorita="Madrid";
	
	//Leer la cookie
	Cookie[] cookies = request.getCookies();
	//Buscar las preferencias
	if(cookies!=null){
		for(Cookie cookieTemp:cookies){
			if("agencia_viajes.ciudad_favorita".equals(ciudad_favorita));{
				ciudad_favorita=cookieTemp.getValue();
				break;
			}
		}
	}
	%>
	
	<h3> Vuelos a <%= ciudad_favorita %></h3>
	<p> Ejemplo </p>
	<p> Ejemplo </p>

	<h3> Hoteles en <%= ciudad_favorita %></h3>
	<p> Ejemplo </p>
	<p> Ejemplo </p>

</body>
</html>