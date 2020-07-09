package l201_227BBDD.l222_223Metadatos;

import java.sql.*;

public class Main222 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection miConexion=null;
        try{
            miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pildinfo", "root", "secret");

            // Obtención Metadata
            DatabaseMetaData databaseMetaData = miConexion.getMetaData();
            System.out.println("Gestor de BBDD: "+databaseMetaData.getDatabaseProductName()+"\n"+
                    "getDatabaseProductVersion "+databaseMetaData.getDatabaseProductVersion()+"\n"+
                    "getDriverName "+databaseMetaData.getDriverName()+"\n"+
                    "getURL "+databaseMetaData.getURL()+"\n"+
                    "getUserName "+databaseMetaData.getUserName()+"\n"+
                    "getClientInfoProperties "+databaseMetaData.getClientInfoProperties()+"\n"+
                    "getMaxIndexLength "+databaseMetaData.getMaxIndexLength());

            ResultSet resultSet = databaseMetaData.getTables(null, null, "p%",null);
            System.out.println("NOMBRES DE LAS TABLAS");
            while(resultSet.next()){
                System.out.println(resultSet.getString(3));
            }
            resultSet = databaseMetaData.getColumns(null, null, "productos", null);
            while(resultSet.next()){
                System.out.println(resultSet.getString("column_name"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}