package l201_227BBDD.l224_227Practica2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MarcoBBDD mimarco = new MarcoBBDD();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }

}

class MarcoBBDD extends JFrame {
    public MarcoBBDD() {
        setBounds(300, 300, 700, 700);
        LaminaBBDD milamina = new LaminaBBDD();
        add(milamina);
    }
}

class LaminaBBDD extends JPanel {

    private JComboBox comboTablas;
    private JTextArea areaInformacion;
    private Connection connection;
    private FileReader fileReader;

    public LaminaBBDD() {
        setLayout(new BorderLayout());

        comboTablas = new JComboBox();
        connect();
        fillTables();

        comboTablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = (String) comboTablas.getSelectedItem();
                showTableInfo(tableName);

            }
        });
        areaInformacion = new JTextArea();
        add(areaInformacion, BorderLayout.CENTER);
        add(comboTablas, BorderLayout.NORTH);
    }

    public void connect() {
        connection = null;
        String datos[] = new String[3];
        try {
            fileReader = new FileReader(new File("resources\\datos_config.txt"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
            JFileChooser chooser = new JFileChooser("\\resources");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    fileReader = new FileReader(chooser.getSelectedFile());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (int i = 0; i <= 2; i++) {
                datos[i] = bufferedReader.readLine();
            }
            fileReader.close();
            connection = DriverManager.getConnection(datos[0], datos[1], datos[2]);

        } catch (SQLException | IOException throwables) {

            throwables.printStackTrace();
        }
    }

    public void fillTables() {

        try {
            ResultSet resultSet = null;
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getTables(null, null, null, null);
            while (resultSet.next()) {
                comboTablas.addItem(resultSet.getString("Table_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void showTableInfo(String tableName) {
        ArrayList<String> columns = new ArrayList<>();
        String consulta = "SELECT * FROM " + tableName;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            areaInformacion.setText("");
            for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                columns.add(resultSetMetaData.getColumnLabel(i));
            }
            while (resultSet.next()) {
                for (String cadena : columns) {
                    areaInformacion.append(resultSet.getString(cadena) + " ");
                }
                areaInformacion.append("\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}



