package l201_227BBDD.l210_217MVC.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection connection;
    public Conexion(){

    }

    public Connection getConnection(){
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pildInfo", "root", "secret");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
