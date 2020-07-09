package l065_80Events.L65_66Events;
// 66
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Implements ActionListener
public class Panel extends JPanel implements ActionListener {

    // FIELDS
    JButton botonAmarillo, botonMarron, botonRosa, botonNulo;

    // CONSTRUCTOR
    public Panel(){
        botonAmarillo = new JButton("Amarillo");
        botonMarron = new JButton("Marron");
        botonRosa = new JButton("Rosa");
        botonNulo = new JButton("Nulo");

        // addActionListener. Parameter the component that will receive the event
        botonAmarillo.addActionListener(this);
        botonMarron.addActionListener(this);
        botonRosa.addActionListener(this);
        botonNulo.addActionListener(this);
        add(botonAmarillo);
        add(botonMarron);
        add(botonRosa);
        add(botonNulo);



        // Pruebas propias
        Button boton = new Button();
        boton.addActionListener(boton);
        add(boton);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object pulsedButton = e.getSource();
        if (pulsedButton==botonAmarillo) this.setBackground(Color.YELLOW);
        if (pulsedButton==botonMarron) this.setBackground(Color.ORANGE);
        if(pulsedButton==botonRosa) this.setBackground(Color.PINK);
        if (pulsedButton==botonNulo) this.setBackground(null);

    }
}
