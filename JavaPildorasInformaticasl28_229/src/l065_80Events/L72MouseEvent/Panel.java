package l065_80Events.L72MouseEvent;
// 66

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            MainFrame marco = new MainFrame();
        }
    }

}
