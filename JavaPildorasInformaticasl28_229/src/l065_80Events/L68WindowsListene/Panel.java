package l065_80Events.L68WindowsListene;
// 66

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// Implements ActionListener
public class Panel extends JPanel {

    // FIELDS
    JButton botonNuevaVentana;

    // CONSTRUCTOR
    public Panel(){
        botonNuevaVentana=new JButton("Nueva Ventana");
        add(botonNuevaVentana);
        NuevaVentana nuevaVentana = new NuevaVentana();
        botonNuevaVentana.addActionListener(nuevaVentana);


    }

    class NuevaVentana implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AFrame marco = new AFrame();
        }
    }

}
