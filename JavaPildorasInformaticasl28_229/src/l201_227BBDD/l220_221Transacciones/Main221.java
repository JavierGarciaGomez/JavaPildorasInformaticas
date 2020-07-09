package l201_227BBDD.l220_221Transacciones;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main221 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection miConexion=null;
        try{
            miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pildinfo", "root", "secret");
            // Autocommit
            miConexion.setAutoCommit(false);
            Statement miStatement =miConexion.createStatement();
            String instruccionSql_1="DELETE FROM PRODUCTOS WHERE PAIS='ITALIA'";
            String instruccionSql_2="DELETE FROM PRODUCTOS WHERE PRECIO>300";
            String instruccionSql_3="UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15";


            boolean seEjecutara=ejecutarTransaccion();
            if(seEjecutara){
                miStatement.executeUpdate(instruccionSql_1);
                miStatement.executeUpdate(instruccionSql_2);
                miStatement.executeUpdate(instruccionSql_3);
                miConexion.commit();
                System.out.println("Datos ACTUALIZADOS correctamente");
            } else{
                System.out.println("No se hicieron cambios");
            }


        }catch(Exception e){
            try {
                miConexion.rollback();
                System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private static boolean ejecutarTransaccion() {
        String ejecucion= JOptionPane.showInputDialog("Ejecutamos transacción?");
        if (ejecucion.equalsIgnoreCase("sí")) return true;
        else return false;
    }
}