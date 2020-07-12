<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserta producto</title>
</head>
<body>
	<h1 style="text-align: center">Insertar registros</h1>
	<form name="form1" method="get" action="ControladorProductos">
	<input type="hidden" name="instruccion" value="insertarBBDD">
		<table>
			<tr>
				<td width="25%">Código</td>
				<td width="75%"><label for="CArt"></label> <input type="text"
					name="CArt" id="CArt"></td>
			</tr>
			<tr>
				<td width="25%">Sección</td>
				<td width="75%"><label for="seccion"></label> <input
					type="text" name="seccion" id="seccion"></td>
			</tr>
			<tr>
				<td width="25%">Nombre</td>
				<td width="75%"><label for="NArt"></label> <input type="text"
					name="NArt" id="NArt"></td>
			</tr>
			<tr>
				<td width="25%">Fecha</td>
				<td width="75%"><label for="fecha"></label> <input type="text"
					name="fecha" id="fecha"></td>
			</tr>
			<tr>
				<td width="25%">Precio</td>
				<td width="75%"><label for="precio"></label> <input type="text"
					name="precio" id="precio"></td>
			</tr>
			<tr>
				<td width="25%">Importado</td>
				<td width="75%"><label for="importado"></label> <input
					type="text" name="importado" id="importado"></td>
			</tr>
			<tr>
				<td width="25%">País de origen</td>
				<td width="75%"><label for="pOrig"></label> <input type="text"
					name="pOrig" id="pOrig"></td>
			</tr>
			<tr>
				<td><input type="submit" name="envio" id="envio" value="Enviar"></td>
				<td><input type="reset" name="borrar" id="borrar"
					value="Restablecer"></td>
			</tr>

		</table>
	</form>


</body>
</html>