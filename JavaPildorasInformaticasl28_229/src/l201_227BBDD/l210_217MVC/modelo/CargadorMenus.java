package l201_227BBDD.l210_217MVC.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargadorMenus {
    public Conexion conexion;
    public ResultSet resultSet;
    public ResultSet resultSet2;

    public CargadorMenus() {
        conexion=new Conexion();
    }

    public String ejecutaConsultas(){
        Producto producto=null;
        Connection connectionBBDD =conexion.getConnection();
        try{
            Statement secciones = connectionBBDD.createStatement();
            Statement paises = connectionBBDD.createStatement();
            resultSet=secciones.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");

            resultSet2=paises.executeQuery("SELECT DISTINCTROW PAIS FROM PRODUCTOS");
            producto=new Producto();
            producto.setSeccion(resultSet.getString(1));
            producto.setPais(resultSet2.getString(1));
            resultSet.close();
            resultSet2.close();

            connectionBBDD.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
