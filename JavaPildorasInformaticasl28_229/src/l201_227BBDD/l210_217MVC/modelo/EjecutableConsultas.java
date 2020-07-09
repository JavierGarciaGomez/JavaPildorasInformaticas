package l201_227BBDD.l210_217MVC.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjecutableConsultas {
    private String pruebas;
    private Conexion conexion;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private final String consultaSeccion = "SELECT NOMBRE, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE SECCION=?";
    private final String consultaPais = "SELECT NOMBRE, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE PAIS=?";
    private final String consultaAmbos = "SELECT NOMBRE, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE SECCION=? AND PAIS=?";
    private final String consultaTodos = "SELECT NOMBRE, SECCION, PRECIO, PAIS FROM PRODUCTOS";

    public EjecutableConsultas() {
        conexion = new Conexion();
    }

    public ResultSet filtraBBDD(String seccion, String pais) {
        try {
            Connection connection = conexion.getConnection();
            resultSet=null;

            if (!seccion.equals("Todos") && pais.equals("Todos")) {
                preparedStatement = connection.prepareStatement(consultaSeccion);
                preparedStatement.setString(1, seccion);
            } else if (seccion.equals("Todos") && !pais.equals("Todos")) {
                preparedStatement = connection.prepareStatement(consultaPais);
                preparedStatement.setString(1, pais);
            } else if (!seccion.equals("Todos") && !pais.equals("Todos")) {
                preparedStatement = connection.prepareStatement(consultaAmbos);
                preparedStatement.setString(1, seccion);
                preparedStatement.setString(2, pais);
            } else {
                preparedStatement = connection.prepareStatement(consultaTodos);
            }
            resultSet= preparedStatement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
