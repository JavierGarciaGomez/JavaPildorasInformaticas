package com.MVC.productos;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ModeloProductos modeloProductos;

	// Definir o establecer el Datasource
	@Resource(name = "jdbc/productos")
	private DataSource miPool;

	@Override
	public void init() throws ServletException {

		// TODO Auto-generated method stub

		try {
			modeloProductos = new ModeloProductos(miPool);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		;

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Leer el parámetro del formulario
		String elComando = request.getParameter("instruccion");
		// Si no se envía el parámetro, listar productos
		if (elComando == null)
			elComando = "listar";
		// Redirigir el flujo de ejecución al método adecuado

		switch (elComando) {
		case "listar":
			obtenerProductos(request, response);
			break;
		case "insertarBBDD":
			try {
				agregarProducto(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "cargar":
			try {
				cargaProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		case "actualizarBBDD":
			try {
				actualizaProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "eliminar":
			try {
				eliminarProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			obtenerProductos(request, response);
		}

	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		List<Producto> productos;

		try {
			productos = modeloProductos.getProductos();

			// Agregar lista de productos del Requst
			request.setAttribute("LISTAPRODUCTOS", productos);
			// Enviar ese request a la página JSP
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {

		}
	}

	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		// Leer la info del producto que viene del formulario
		String codArticulo = request.getParameter("CArt");
		String seccion = request.getParameter("seccion");
		String nombreArticulo = request.getParameter("NArt");
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double precio = Double.parseDouble(request.getParameter("precio"));
		String importado = request.getParameter("importado");
		String paisOrigen = request.getParameter("POrig");
		// Crear un objeto del tipo producto
		Producto producto = new Producto(codArticulo, seccion, nombreArticulo, precio, fecha, importado, paisOrigen);
		// Enviar el objeto al modelo e insertar el objeto producto en la BBDD
		modeloProductos.agregarProducto(producto);
		// Volver al listado de productos
		obtenerProductos(request, response);

	}

	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// Leer el código artículo del listado
		String codigoArticulo = request.getParameter("cArticulo");
		// Enviar codigo artículo a modelo
		Producto producto = modeloProductos.getProducto(codigoArticulo);
		// colocar atributo correspondiente al C artículo
		request.setAttribute("ProductoActualizar", producto);
		System.out.println("ESTOY SALIENDO DE CARGAPRODUCTO " + producto);
		// Enviar producto al formulario de actualizar (JSP)
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ActualizarProductos.jsp");
		requestDispatcher.forward(request, response);

	}

	private void actualizaProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// Leer los datos del formulario actualizar
		String codArticulo = request.getParameter("cArt");
		String seccion = request.getParameter("seccion");
		String nombreArticulo = request.getParameter("NArt");
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double precio = Double.parseDouble(request.getParameter("precio"));
		String importado = request.getParameter("importado");
		String paisOrigen = request.getParameter("POrig");

		// Crear un objeto producto con la info del formulario

		Producto producto = new Producto(codArticulo, seccion, nombreArticulo, precio, fecha, importado, paisOrigen);
		System.out.println("el codArticulo es: " + codArticulo + " y los datos del producto" + producto);
		// Actualizar la BBDD
		modeloProductos.actualizarProducto(producto);

		// Volver al listado con la info actualizada
		obtenerProductos(request, response);

	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// Leer los datos del formulario
		String codArticulo = request.getParameter("cArticulo");
		// Borrar producto de la BBDD
		try {
			modeloProductos.borrarProducto(codArticulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Volver al listado con la info actualizada
		obtenerProductos(request, response);

	}

}
