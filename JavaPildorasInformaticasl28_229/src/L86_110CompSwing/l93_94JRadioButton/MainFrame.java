package L86_110CompSwing.l93_94JRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton button1, button2, button3;
    private JLabel texto;
    private JPanel northPanel, centerPanel;

    public MainFrame(){
        setBounds(600, 300, 600, 350);

        // JPanels and layouts
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(new BorderLayout());
        this.add(panel);
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,2));
        panel.add(northPanel, BorderLayout.NORTH);
        centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);

        insertButtons("pequeño", false, 12);
        insertButtons("mediano", false, 24);
        insertButtons("grande", false, 40);

        texto=new JLabel("En un lugar de la Mancha");
        centerPanel.add(texto);


        /* FORMA ANTERIOR SIN METODO

        button1=new JRadioButton("pequeño", false);
        button2=new JRadioButton("mediano", false);
        button3=new JRadioButton("grande", false);

        buttonGroup = new ButtonGroup();

        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);

        northPanel.add(button1);
        northPanel.add(button2);
        northPanel.add(button3);

        button1.addActionListener(new rbActionListener());
        button2.addActionListener(new rbActionListener());
        button3.addActionListener(new rbActionListener());

        texto=new JLabel("En un lugar de la Mancha");
        centerPanel.add(texto);
        */

        setVisible(true);
    }

    public void insertButtons (String nombre, boolean selected, int size){
        JRadioButton jRadioButton = new JRadioButton(nombre, selected);
        northPanel.add(jRadioButton);
        buttonGroup.add(jRadioButton);
        jRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setFont(new Font("Serif", Font.PLAIN, size));
            }
        });

    }


    private class rbActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1) texto.setFont(new Font("Serif", Font.PLAIN, 10));
            else if (e.getSource()==button2) texto.setFont(new Font("Serif", Font.PLAIN, 25));
            else if (e.getSource()==button3) texto.setFont(new Font("Serif", Font.PLAIN, 50));
        }
    }
}
