package com.MVC.productos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
	private DataSource dataSource;

	public ModeloProductos(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Producto> getProductos() throws Exception {
		List<Producto> productos = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// establecer conexión
			connection = dataSource.getConnection();
			// crear sentencia
			statement = connection.createStatement();
			String SQL = "SELECT *FROM productos";
			// ejecutar SQL
			resultSet = statement.executeQuery(SQL);
			// recorrer el resultSet
			while (resultSet.next()) {

				String c_art = resultSet.getString(1);
				String seccion = resultSet.getString(2);
				String nArt = resultSet.getString(3);
				double precio = resultSet.getDouble(4);
				Date fecha = resultSet.getDate(5);
				String importado = resultSet.getString(6);
				String paisOrigen = resultSet.getString(7);

				Producto tempProd = new Producto(c_art, seccion, nArt, precio, fecha, importado, paisOrigen);
				productos.add(tempProd);

			}
		} catch (Exception e) {

		} finally {
			statement.close();
			connection.close();

		}

		return productos;

	}

	public void agregarProducto(Producto producto) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		// Obtener la conexión
		try {
			connection = dataSource.getConnection();
			// Crear instrucción SQL
			String sql = "INSERT INTO productos (cod, seccion, nombre, precio, fecha, importado, pais) VALUES (?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			// Establecer parámetros para el producto
			preparedStatement.setString(1, producto.getcArt());
			preparedStatement.setString(2, producto.getSeccion());
			preparedStatement.setString(3, producto.getnArt());
			preparedStatement.setDouble(4, producto.getPrecio());
			java.util.Date utilDate = producto.getFecha();
			java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
			preparedStatement.setDate(5, fechaConvertida);
			preparedStatement.setString(6, producto.getImportado());
			preparedStatement.setString(7, producto.getPorig());

			// Ejeutar SQL
			System.out.println(preparedStatement);
			preparedStatement.execute();

		} catch (Exception e) {
		} finally {
			preparedStatement.close();
			connection.close();

		}

	}

	public Producto getProducto(String codigoArticulo) throws Exception {
		Producto producto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String cArticulo = codigoArticulo;

		// Establecer conexión
		try {
			connection = dataSource.getConnection();
			// Crear SQL
			String sql = "SELECT * FROM productos WHERE COD=?";
			// Crear la consulta preparada
			preparedStatement = connection.prepareStatement(sql);
			// Establecer parametros
			preparedStatement.setNString(1, cArticulo);
			// Ejecutar consulta
			resultSet = preparedStatement.executeQuery();

			// Obtener los datos de respuesta
			if (resultSet.next()) {
				System.out.println("Halle el producto " + codigoArticulo);
				String cod = resultSet.getString(1);
				String seccion = resultSet.getString(2);
				String nArt = resultSet.getString(3);
				double precio = resultSet.getDouble(4);
				Date fecha = resultSet.getDate(5);
				String importado = resultSet.getString(6);
				String paisOrigen = resultSet.getString(7);

				producto = new Producto(cod, seccion, nArt, precio, fecha, importado, paisOrigen);
				System.out.println("Halle el producto " + producto);

			} else {
				throw new Exception("No hemos encontrado el producto con código= " + cArticulo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();

		}

		return producto;

	}

	public void actualizarProducto(Producto producto) throws Exception {
		System.out.println("producto recibido " + producto);
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		// Obtener la conexión
		try {
			connection = dataSource.getConnection();
			// Crear instrucción SQL
			String sql = "UPDATE productos SET seccion=?, nombre=?, precio=?, fecha=?, importado=?, pais=? "
					+ "WHERE COD=?";
			preparedStatement = connection.prepareStatement(sql);
			// Establecer parámetros para el producto
			preparedStatement.setString(1, producto.getSeccion());
			preparedStatement.setString(2, producto.getnArt());
			preparedStatement.setDouble(3, producto.getPrecio());
			java.util.Date utilDate = producto.getFecha();
			java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
			preparedStatement.setDate(4, fechaConvertida);
			preparedStatement.setString(5, producto.getImportado());
			preparedStatement.setString(6, producto.getPorig());
			preparedStatement.setString(7, producto.getcArt());

			// Ejeutar SQL
			System.out.println(preparedStatement);
			preparedStatement.execute();

		} catch (Exception e) {
		} finally {
			preparedStatement.close();
			connection.close();

		}

	}

	public void borrarProducto(String codArticulo) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		// Obtener la conexión
		try {
			connection = dataSource.getConnection();
			// Crear instrucción SQL
			String sql = "DELETE FROM productos WHERE COD=?";
			preparedStatement = connection.prepareStatement(sql);
			// Establecer parámetros para el producto
			preparedStatement.setString(1, codArticulo);
			// Ejecutar SQL
			System.out.println(preparedStatement);
			preparedStatement.execute();

		} catch (Exception e) {

		} finally {
			preparedStatement.close();
			connection.close();

		}

	}
}
