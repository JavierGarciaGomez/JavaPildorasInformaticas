package l065_80Events.L80MultiplesOyentes;
// 66

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Implements ActionListener
public class Panel extends JPanel {
    JButton butCloseWindow;
    // CONSTRUCTOR
    public Panel(){
        JButton butNewWindow = new JButton("Nuevo");
        butCloseWindow = new JButton("Cerrar");
        butNewWindow.addActionListener(new OyenteNuevo());
        add(butNewWindow);
        add(butCloseWindow);


    }

    private class OyenteNuevo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoEmergente marco =new MarcoEmergente(butCloseWindow);
        }
    }

}

class MarcoEmergente extends JFrame{
    private static int numVentana=0;

    public MarcoEmergente(JButton butCloseWindow){
        numVentana++;
        setTitle("Ventana "+numVentana);
        setBounds(40*numVentana, 40*numVentana, 300, 150);
        setVisible(true);
        CierraTodos cierraTodos = new CierraTodos();
        butCloseWindow.addActionListener(new CierraTodos());
    }

    private class CierraTodos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
