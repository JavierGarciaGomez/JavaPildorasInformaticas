<meta charset="UTF-8">
<%@ page import="java.util.*"%>
<html>
<title>Lista Compra</title>

<body>
	<form name="Formulario_Compra" action="Lista_Compra.jsp">

		<p>Artículos a comprar:</p>
		<p>
			<label> <input type="checkbox" name="articulos" value="agua ">
				Agua
			</label> <br> <label> <input type="checkbox" name="articulos"
				value="leche"> Leche
			</label> <br> <label> <input type="checkbox" name="articulos"
				value="pan"> Pan
			</label> <br> <label> <input type="checkbox" name="articulos"
				value="mazanas"> Manzanas
			</label> <br> <label> <input type="checkbox" name="articulos"
				value="carne"> Carne
			</label> <br> <label> <input type="checkbox" name="articulos"
				value="pescado"> Pescado
			</label>
		</p>
		<p>
			<input type="submit" name="button" id="button" value="Enviar">
			<br>
		</p>
	</form>

	<h2>Carro de la compra</h2>
	<ul>

		<%
		List<String> listaElementos = (List<String>)session.getAttribute("misElementos");		
		
		if(listaElementos==null){
			listaElementos=new ArrayList<String>();
			session.setAttribute("misElementos", listaElementos);
		}
		
		
		String[] elementos = request.getParameterValues("articulos");

		if (elementos != null) {
			for (String elemTemp : elementos) {
				listaElementos.add(elemTemp);
			}

		}
		
		for(String elemTemp: listaElementos){
			out.println("<li>"+elemTemp+"</li>");
		}
		
		%>

	</ul>
</body>

</html>