package l111_122AplicacionesGraficas.l115_120DisposicionesAvanzadas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main115 {
    public static void main(String[] args){
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Untitled");
        mainFrame.setBounds(600, 350, 200, 200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se crean las cajas, la primera agrupa a todas
        Box cajaVertical=Box.createVerticalBox();
        Box cajaH1 = Box.createHorizontalBox();
        Box cajaH2=Box.createHorizontalBox();
        Box cajaH3=Box.createHorizontalBox();

        // Se crean los elementos de la primera caja y se agregan
        JLabel rotulo1 = new JLabel("Nombre");
        JTextField texto1=new JTextField(10);
        texto1.setMaximumSize(texto1.getPreferredSize()); // se establece el tamaño máximo del textfield con getpreferredsize (10 caracteres)
        cajaH1.add(rotulo1);
         cajaH1.add(Box.createHorizontalStrut(10)); // createHorizontalStrut para hacer una separación entre los elementos de la caja.
        cajaH1.add(texto1);

        // Se hace lo mismo con la segunda caja
        JLabel rotulo2 = new JLabel("Contraseña");
        JTextField texto2 = new JTextField(10);
        texto2.setMaximumSize(texto2.getPreferredSize());
        cajaH2.add(rotulo2);
        cajaH2.add(Box.createHorizontalStrut(10));
        cajaH2.add(texto2);

        // Se hace lo mismo con la tercera caja
        JButton boton1=new JButton("Ok");
        JButton boton2=new JButton("Cancelar");
        cajaH3.add(boton1);
        cajaH3.add(Box.createGlue()); // Hace que sus elementos no se muevan
        cajaH3.add(boton2);

        // Se agregan las tres cajas a la caja principal y se agrega la caja principal
        cajaVertical.add(cajaH1);
        cajaVertical.add(cajaH2);
        cajaVertical.add(cajaH3);

        mainFrame.add(cajaVertical, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }

}
