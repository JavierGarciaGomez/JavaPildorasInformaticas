<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, java.sql.*, jsp.com.jsptags.*"%>

<%
	ArrayList<Empleado> datos = new ArrayList<>();

try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pildinfo", "root", "secret");
	Statement statement = connection.createStatement();
	String instruccionSQL = "SELECT * FROM EMPLEADOS";
	ResultSet rs = statement.executeQuery(instruccionSQL);
	while (rs.next()) {
		datos.add(new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
	}
	rs.close();
	connection.close();

} catch (Exception e) {
	out.println("Ha habido un error");
}

pageContext.setAttribute("losEmpleados", datos);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>id</td>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Puesto</td>
			<td>Salario</td>
			<td>Bonús</td>
		</tr>
		<c:forEach var="EmpTemp" items="${losEmpleados }">
			<tr>
				<td>${EmpTemp.id}</td>
				<td>${EmpTemp.nombre}</td>
				<td>${EmpTemp.apellido}</td>
				<td>${EmpTemp.puesto}</td>
				<td>${EmpTemp.salario}</td>
				<td><c:if test="${EmpTemp.salario<40000}">5000</c:if> <c:if
						test="${EmpTemp.salario>=40000}">------</c:if></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>