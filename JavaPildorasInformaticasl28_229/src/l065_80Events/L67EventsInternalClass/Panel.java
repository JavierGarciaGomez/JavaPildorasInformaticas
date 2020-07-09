package l065_80Events.L67EventsInternalClass;
// 66

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Implements ActionListener
public class Panel extends JPanel{

    // FIELDS
    JButton botonAmarillo, botonMarron, botonRosa, botonNulo;

    // CONSTRUCTOR
    public Panel(){
        botonAmarillo = new JButton("Amarillo");
        botonMarron = new JButton("Marron");
        botonRosa = new JButton("Rosa");
        botonNulo = new JButton("Nulo");

        // addActionListener. Parameter the component that will receive the event

        add(botonAmarillo);
        add(botonMarron);
        add(botonRosa);
        add(botonNulo);

        // Se instancia la clase interna que fungirá como actionlistener
        ColorFondo amarillo = new ColorFondo(Color.yellow);
        ColorFondo marron = new ColorFondo(Color.ORANGE);
        ColorFondo rosa = new ColorFondo(Color.PINK);
        ColorFondo nulo = new ColorFondo(null);

        // Se agrega el actionlistener
        botonAmarillo.addActionListener(amarillo);
        botonMarron.addActionListener(marron);
        botonRosa.addActionListener(rosa);
        botonNulo.addActionListener(nulo);
    }

    // Clase interna
    class ColorFondo implements ActionListener {

        private Color color;
        public ColorFondo(Color color){
            this.color=color;

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setBackground(color);

        }
    }
}
