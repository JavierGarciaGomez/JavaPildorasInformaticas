package l201_227BBDD.l220_221Transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main220 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection miConexion=null;
        try{
            miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pildinfo", "root", "secret");
            // Autocommit
            miConexion.setAutoCommit(false);
            Statement miStatement =miConexion.createStatement();
            String instruccionSql_1="INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
            miStatement.executeUpdate(instruccionSql_1);
            String instruccionSql_2="INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";
            miStatement.executeUpdate(instruccionSql_2);

            miConexion.commit();

            System.out.println("Datos INSERTADOS correctamente");
        }catch(Exception e){
            System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
            try {
                miConexion.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}