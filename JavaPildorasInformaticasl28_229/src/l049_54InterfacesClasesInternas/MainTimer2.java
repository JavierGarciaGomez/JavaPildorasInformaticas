package l049_54InterfacesClasesInternas;
// Modificaciones: 53

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MainTimer2 {
    public static void main(String[] args) {
        Reloj reloj = new Reloj(3000, true);
        reloj.enMarcha();
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");

    }
}

// 53.
class Reloj{
    private int intervalo;
    private boolean sonido;
    public Reloj(int intervalo, boolean sonido){
        this.intervalo=intervalo;
        this.sonido=sonido;
    }

    // MÉTODOS
    // Poner en marcha

    public void enMarcha(){
        ActionListener oyente = new DameLaHora2();
        Timer myTimer = new Timer(intervalo, oyente);
        myTimer.start();

    }

    // Mi clase interna
    private class DameLaHora2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("La hora es "+new Date());
            if(sonido) Toolkit.getDefaultToolkit().beep();
        }
    }
}