package l201_227BBDD.l201_205;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        // 1. Crear conexión
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pildInfo", "root", "secret");
        // 2. Crear un objeto Statement
        Statement statement = connection.createStatement();
        // 3. Crear Query
        ResultSet resultSet=statement.executeQuery("SELECT *FROM USUARIOS;");
        // 4. Recorrer ResultSet
        while(resultSet.next()){
            System.out.println(resultSet.getString("nombre")+" "+resultSet.getString("apellido")+" "+resultSet.getString("email"));
        }
        statement.close();
        // 204

        // Insertar
        statement = connection.createStatement();
        statement.executeUpdate("Insert into usuarios (nombre, apellido, email) values ('NuevoNombre', 'nuevoApellido', 'nuevo@gmail.com');");

        // Update
        statement = connection.createStatement();
        statement.executeUpdate("UPDATE usuarios SET nombre='Bernardo' WHERE nombre='Bernadrdo';");

        // Delete
        statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM usuarios WHERE nombre='NuevoNombre';");

        // 205 PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT email FROM usuarios " +
                "WHERE nombre=? AND apellido=?;");
        preparedStatement.setString(1, "Adriana");
        preparedStatement.setString(2, "Álvarez");
        System.out.println(preparedStatement.getMetaData());

        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

        // Reutilización
        preparedStatement.setString(1, "Bernardo");
        preparedStatement.setString(2, "Benítez");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

        connection.close();
    }
}
