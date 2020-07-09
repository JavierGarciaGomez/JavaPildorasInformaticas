package L81.Layouts.L83_85Calculadora;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MainFrame myFrame = new MainFrame();
    }
}

class MainFrame extends JFrame {
    public MainFrame(){

        setVisible(true);
        setBounds(1500,200,350,450);
        setTitle("Calculadora");
        setResizable(false);
        setContentPane(new MainPanel());
        setVisible(true);
        //Adaptarse al tamaño por defecto de lo que contiene
        //pack();
    }
}

class MainPanel extends JPanel{

    // FIELDS
    private JPanel screenPanel, buttonPanel;
    private JTextField screen;
    private double firstValue;
    private boolean isFirst;
    private double resultado;
    private String ultimaOperacion;


    MainPanel(){
        // Layout
        setLayout(new BorderLayout());

        // Panel superior
        screenPanel = new JPanel();
        add(screenPanel, BorderLayout.NORTH);
        screenPanel.setBackground(Color.RED);
        screenPanel.setPreferredSize(new Dimension(350, 100));
        screen = new JTextField();
        screenPanel.add(screen);
        screen.setBounds(10, 10, 250, 70);
        screen.setBackground(Color.PINK);
        screen.setPreferredSize(new Dimension(250,70));
        screen.setFont(new Font("Arial", Font.BOLD, 24));
        screen.setEditable(false);

        // Panel inferior
        buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setPreferredSize(new Dimension(350, 400));
        buttonPanel.setBackground(Color.PINK);
        buttonPanel.setLayout(new GridLayout(4,4));

        // Instancias de actionListener
        ActionListener insertaNum = new InsertaNum();
        ActionListener realizaOperacion = new RealizaOperacion();

        // Señalar que se empieza la ejecución para que el número sea cero
        isFirst=true;
        ultimaOperacion= "=";

        agregarBotones("7", insertaNum);
        agregarBotones("8", insertaNum);
        agregarBotones("9", insertaNum);
        agregarBotones("X", realizaOperacion);
        agregarBotones("4", insertaNum);
        agregarBotones("5", insertaNum);
        agregarBotones("6", insertaNum);
        agregarBotones("-", realizaOperacion);
        agregarBotones("1", insertaNum);
        agregarBotones("2", insertaNum);
        agregarBotones("3", insertaNum);
        agregarBotones("+", realizaOperacion);
        agregarBotones("0", insertaNum);
        agregarBotones("/", realizaOperacion);
        agregarBotones("RESET", realizaOperacion);
        agregarBotones("=", realizaOperacion);
    }

    // METHODS

    private void agregarBotones(String rotulo, ActionListener al){
        JButton boton = new JButton(rotulo);
        boton.addActionListener(al);
        buttonPanel.add(boton);
    }

    // INTERNAL CLASS
    private class InsertaNum implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String botonPulsado = e.getActionCommand();
            // Test if is the first number
            if(isFirst) {
                screen.setText("");
                isFirst=false;
            }
            screen.setText(screen.getText()+e.getActionCommand());
        }
    }

    private class RealizaOperacion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String operacion = e.getActionCommand();
            calcular(Double.parseDouble(screen.getText()));
            ultimaOperacion=operacion;
            isFirst=true;
        }

        public void calcular(double x){
            if(ultimaOperacion.equals("+")){
                resultado+=x;
            }

            else if(ultimaOperacion.equals("-")){
                resultado-=x;
            }

            else if(ultimaOperacion.equals("X")){
                resultado*=x;
            }

            else if(ultimaOperacion.equals("/")){
                resultado/=x;
            }

            else if(ultimaOperacion.equals("=")){
                resultado=x;
            }

            else if(ultimaOperacion.equals("RESET")){
                resultado=0;

            }

            screen.setText(String.valueOf(resultado));
        }
    }
}

