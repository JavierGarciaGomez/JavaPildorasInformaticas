package l168_178Threads.l170;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Main170 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame marco = new MarcoRebote();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

// CLASES ADICIONALES
class PelotaHilos implements Runnable {
    private Pelota pelota;
    private Component componente;

    public PelotaHilos(Pelota unaPelota, Component unComponent) {
        pelota = unaPelota;
        componente = unComponent;
    }

    public void run() {
        // mientras no se interrumpa, la pelota se moverá
//        while(!Thread.interrupted()){
//            pelota.mueve_pelota(componente.getBounds());
//            componente.paint(componente.getGraphics());
//        }

        System.out.println("Estado del hilo al comenzar: "+Thread.currentThread().isInterrupted());

        while(!Thread.currentThread().isInterrupted()){
            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());

            try{
                Thread.sleep(4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        System.out.println("Estado del hilo al terminar: "+Thread.currentThread().isInterrupted());

//        for (int i = 1; i <= 3000; i++) {
//            pelota.mueve_pelota(componente.getBounds());
//            componente.paint(componente.getGraphics());
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
    }
}

//Movimiento de la pelota-----------------------------------------------------------------------------------------
class Pelota {
    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    // Mueve la pelota invirtiendo posición si choca con límites
    public void mueve_pelota(Rectangle2D limites) {
        x += dx;
        y += dy;
        if (x < limites.getMinX()) {
            x = limites.getMinX();
            dx = -dx;
        }
        if (x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }
        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }
        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }
    }

    //Forma de la pelota en su posición inicial
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel {
    //Añadimos pelota a la lámina
    public void add(Pelota b) {
        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Pelota b : pelotas) {
            g2.fill(b.getShape());
        }
    }

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}

//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame {
    Thread thread1, thread2, thread3;
    JButton start1, start2, start3, stop1, stop2, stop3;

    public MarcoRebote() {
        setBounds(600, 300, 600, 350);
        setTitle("Rebotes");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();

        start1=new JButton("Hilo 1");
        start2=new JButton("Hilo 2");
        start3=new JButton("Hilo 3");
        stop1=new JButton("Detén 1");
        stop2=new JButton("Detén 2");
        stop3=new JButton("Detén 3");

        laminaBotones.add(start1);
        laminaBotones.add(start2);
        laminaBotones.add(start3);
        laminaBotones.add(stop1);
        laminaBotones.add(stop2);
        laminaBotones.add(stop3);

        start1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                comienza_el_juego(event);
            }
        });
        start2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                comienza_el_juego(event);
            }
        });
        start3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                comienza_el_juego(event);
            }
        });
        stop1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                detener(event);
            }
        });
        stop2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                detener(event);
            }
        });
        stop3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                detener(event);
            }
        });

        add(laminaBotones, BorderLayout.SOUTH);


    }

    //Ponemos botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }

    //Añade pelota y la bota 1000 veces

    public void comienza_el_juego(ActionEvent event) {
        Pelota pelota = new Pelota();
        lamina.add(pelota);
        Runnable runnable = new PelotaHilos(pelota, lamina);
        if(event.getSource().equals(start1)){
            thread1 = new Thread(runnable);
            thread1.start();
        }
        if(event.getSource().equals(start2)){
            thread2 = new Thread(runnable);
            thread2.start();
        }
        if(event.getSource().equals(start3)){
            thread3 = new Thread(runnable);
            thread3.start();
        }
        
    }

    public void detener(ActionEvent event){
        if(event.getSource().equals(stop1)){
            thread1.interrupt(); //
        }
        else if(event.getSource().equals(stop2)){
            thread2.interrupt(); //
        }
        else if(event.getSource().equals(stop3)){
            thread3.interrupt(); //
        }
    }


    private LaminaPelota lamina;
}

