package com.MVC.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;


/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Definir o establecer el Datasource
	@Resource(name="jdbc/productos")
	private DataSource miPool;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Crea el objeto PrintWriter
		PrintWriter printWriter=response.getWriter();
		response.setContentType("text/plain");
		
		// Conexion
		Connection connection=null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			// El pool de conexiones
			connection=miPool.getConnection();
			String SQL = "SELECT * FROM productos";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(SQL);
			
			while(resultSet.next()) {
				String nombreArticulo=resultSet.getString(3);
				printWriter.println(nombreArticulo);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
