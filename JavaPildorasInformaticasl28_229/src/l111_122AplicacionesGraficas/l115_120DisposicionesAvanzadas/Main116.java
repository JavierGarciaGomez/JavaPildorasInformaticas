package l111_122AplicacionesGraficas.l115_120DisposicionesAvanzadas;

import javax.swing.*;
import java.awt.*;

public class Main116 {
    public static void main(String[] args){
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Untitled");
        mainFrame.setBounds(600, 350, 500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();

        JPanel panel = new JPanel(springLayout);

        JButton boton1 = new JButton("botón 1");
        JButton boton2 = new JButton("botón 2");
        JButton boton3 = new JButton("botón 3");

        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);

        Spring spring = Spring.constant(0,10,100); // Creación del muelle
        Spring fixedSpring = Spring.constant(30); // muelle rígido
        // Poniendo los muelles entre cada elemento
        springLayout.putConstraint(SpringLayout.WEST, boton1, spring, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.WEST, boton2, fixedSpring, SpringLayout.EAST, boton1);
        springLayout.putConstraint(SpringLayout.WEST, boton3, fixedSpring, SpringLayout.EAST, boton2);
        springLayout.putConstraint(SpringLayout.EAST, panel, spring, SpringLayout.EAST, boton3);



        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }

}
