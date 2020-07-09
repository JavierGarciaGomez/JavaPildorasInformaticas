package l201_227BBDD.l218_219ProcedimientosAlmacenados;

import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pildInfo", "root", "secret");
            //218 callableStatement para Procedure
            CallableStatement callableStatement = connection.prepareCall("{call procedimiento}");
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+", "+resultSet.getString(2)+", "
                        +resultSet.getString(3)+", "+resultSet.getString(4)+", "+resultSet.getString(5));
            }
            // 219 Proc con parametros
            int nPrecio = Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
            String nArt = JOptionPane.showInputDialog("Introduce código de artículo");
            callableStatement = connection.prepareCall("{call actualiza_prod(?, ?)}");
            callableStatement.setDouble(1, nPrecio);
            callableStatement.setString(2, nArt);
            callableStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
