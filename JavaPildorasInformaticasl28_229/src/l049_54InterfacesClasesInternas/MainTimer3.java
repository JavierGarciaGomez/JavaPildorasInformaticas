package l049_54InterfacesClasesInternas;
// Modificaciones: 54

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MainTimer3 {
    public static void main(String[] args) {
        Reloj2 reloj2 = new Reloj2();
        reloj2.enMarcha(5000, true);
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");

    }
}

// 53.
class Reloj2 {
    private int intervalo;
    private boolean sonido;
    public Reloj2(){

    }

    // MÉTODOS
    // Poner en marcha

    public void enMarcha(int intervalo, boolean sonido){
        // Mi clase interna
        class DameLaHora2 implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("La hora es "+new Date());
                if(sonido) Toolkit.getDefaultToolkit().beep();
            }

        }
        ActionListener oyente = new DameLaHora2();
        Timer myTimer = new Timer(intervalo, oyente);
        myTimer.start();
    }
}