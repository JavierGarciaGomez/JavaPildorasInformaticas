package l201_227BBDD.l206_209Practica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame mimarco=new Marco_Aplicacion();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class Marco_Aplicacion extends JFrame{

    private JComboBox secciones;
    private JComboBox paises;
    private JTextArea resultado;
    private PreparedStatement preparedStatement;
    private final String consultaSeccion ="SELECT NOMBRE, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE SECCION=?";
    private final String consultaPais ="SELECT NOMBRE, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE PAIS=?";
    private final String consultaAmbos = "SELECT NOMBRE, SECCION, PRECIO, PAIS FROM PRODUCTOS WHERE SECCION=? AND PAIS=?";
    private final String consultaTodos = "SELECT NOMBRE, SECCION, PRECIO, PAIS FROM PRODUCTOS";
    private Connection connection;

    public Marco_Aplicacion(){
        setTitle ("Consulta BBDD");
        setBounds(500,300,400,400);
        setLayout(new BorderLayout());
        JPanel menus=new JPanel();
        menus.setLayout(new FlowLayout());
        secciones=new JComboBox();
        secciones.setEditable(false);
        secciones.addItem("Todos");
        paises=new JComboBox();
        paises.setEditable(false);
        paises.addItem("Todos");
        resultado= new JTextArea(4,50);
        resultado.setEditable(false);
        add(resultado);
        menus.add(secciones);
        menus.add(paises);
        add(menus, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);
        JButton botonConsulta=new JButton("Consulta");
        add(botonConsulta, BorderLayout.SOUTH);
        botonConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ejecutaConsulta();
            }
        });

        // Conexión BBDD
        try {
            // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pildInfo", "root", "secret");
            openConnection();
            Statement statement = connection.createStatement();
            String consulta = "SELECT SECCION FROM PRODUCTOS GROUP BY SECCION";
            ResultSet resultSet = statement.executeQuery(consulta);
            while(resultSet.next()){
                secciones.addItem(resultSet.getString("SECCION"));
            }

            consulta = "SELECT DISTINCTROW PAIS FROM PRODUCTOS";
            resultSet = statement.executeQuery(consulta);
            while(resultSet.next()){
                paises.addItem(resultSet.getString(1));
            }
            resultSet.close();
            closeConnection();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{

        }

    }

    private void ejecutaConsulta()  {
        try {
            openConnection();
            ResultSet resultSet=null;
            resultado.setText("");

            String seccion = (String) secciones.getSelectedItem();
            String pais = (String) paises.getSelectedItem();

            if(!seccion.equals("Todos") && pais.equals("Todos")){
                preparedStatement = connection.prepareStatement(consultaSeccion);
                preparedStatement.setString(1, seccion);
            } else if(seccion.equals("Todos") && !pais.equals("Todos")){
                preparedStatement = connection.prepareStatement(consultaPais);
                preparedStatement.setString(1, pais);
            } else if(!seccion.equals("Todos") && !pais.equals("Todos")){
                preparedStatement = connection.prepareStatement(consultaAmbos);
                preparedStatement.setString(1, seccion);
                preparedStatement.setString(2, pais);
            } else {
                preparedStatement = connection.prepareStatement(consultaTodos);
            }
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
                resultado.append(resultSet.getString(1)+" "+resultSet.getString(2)+" "
                        +resultSet.getString(3)+" "+resultSet.getString(4)+"\n");
            }
            closeConnection();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pildInfo", "root", "secret");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void closeConnection() throws SQLException {
        connection.close();
    }
}