package l111_122AplicacionesGraficas.l115_120DisposicionesAvanzadas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main121 {
    private static JButton boton1, boton2, boton3, boton4;

    public static void main(String[] args){
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Untitled");
        mainFrame.setBounds(500, 300, 400, 250);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        boton1=new JButton("ShowMessageDialog");
        boton2=new JButton("ShowInputDialog");
        boton3=new JButton("showConfirmDialog");
        boton4=new JButton("showOptionDialog");

        // showMessageDialog
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Mensaje de prueba", "ShowMessageDialog", 2, new ImageIcon("iconoMorgana.png"));
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog("Introduce un nombre");
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(panel, "Elige objeto", "V Confirmar", 2);
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showOptionDialog(panel, "Mensaje", "Title", 2, 2,
                        null,new String[]{"aa", "bb"}, 2);
            }
        });

        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);


        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }

    private static class AccionBotones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
