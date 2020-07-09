package L81.Layouts;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }
}

class MainFrame extends JFrame {
    public MainFrame(){

        setVisible(true);
        setBounds(200,200,500,500);

        setContentPane(new MainPanel());
        setVisible(true);


    }
}

class MainPanel extends JPanel{

    MainPanel(){
        //Layout por defecto: FlowLayout
        /*setLayout(new FlowLayout(FlowLayout.RIGHT));
        setLayout(new FlowLayout(FlowLayout.CENTER,150,200));*/


        setLayout(new BorderLayout());
        JPanel panelEste = new JPanel(new FlowLayout());
        add(panelEste, BorderLayout.EAST);


        add(new JButton("Amarillo"), BorderLayout.NORTH);
        add(new JButton("Marrón"), BorderLayout.SOUTH);
        add(new JButton("Rosa"), BorderLayout.WEST);

        panelEste.add(new JButton("Botón Central 1"));
        panelEste.add(new JButton("Botón Central 2"));
        panelEste.add(new JButton("Botón Central 3"));

        // 83 GridLayout
        JPanel panelCentralGL = new JPanel(new GridLayout(2,2));
        add(panelCentralGL);
        panelCentralGL.add(new JTextField(), 0);
        panelCentralGL.add(new JRadioButton(), 1);
        panelCentralGL.add(new JTextArea(), 2);
        panelCentralGL.add(new JButton("Boton"), 3);



    }

}

