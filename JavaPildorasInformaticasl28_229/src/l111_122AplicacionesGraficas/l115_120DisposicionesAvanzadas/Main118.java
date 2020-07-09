package l111_122AplicacionesGraficas.l115_120DisposicionesAvanzadas;

import javax.swing.*;

public class Main118 {
    public static void main(String[] args){
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Untitled");
        mainFrame.setBounds(600, 350, 500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null); // Disposición libre

        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");
        JTextField nombreField = new JTextField(10);
        JTextField apellidoField = new JTextField(10);

        nombre.setBounds(100, 100, 100, 20);
        nombreField.setBounds(200, 100, 100, 20);
        apellido.setBounds(100, 150, 100, 20);
        apellidoField.setBounds(200,150,100,20);


        panel.add(nombre);
        panel.add(apellido);
        panel.add(nombreField);
        panel.add(apellidoField);




        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }

}
