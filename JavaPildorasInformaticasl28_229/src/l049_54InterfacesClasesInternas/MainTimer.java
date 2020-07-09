package l049_54InterfacesClasesInternas;
// Modificaciones: 52, 53

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MainTimer {
    public static void main(String[] args) {
        // La clase Timer recibe como parámetro una interfaz, pero en su lugar estamos metiendo una instancia que implementa la interfaz y funciona
        DameLaHora oyente = new DameLaHora();
        Timer timer = new Timer(3000, oyente);
        timer.start();

        // Como el main se ejecuta rápido, no da tiempo al ejercicio, por lo que se pone este diálogo para detener la ejecución
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
    }
}

class DameLaHora implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Date ahora = new Date();
        System.out.println("La hora actual es "+ahora);
        Toolkit.getDefaultToolkit().beep();


    }
}
