package L86_110CompSwing.l90_91TextArea;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextArea jTextArea;
    private JButton insertButton, saltoButton;

    public MainFrame(){
        setBounds(600, 300, 600, 350);


        // JPanels and layouts
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(new BorderLayout());
        this.add(panel);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,2));
        panel.add(northPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);

        insertButton=new JButton("Insertar");
        saltoButton=new JButton("Salto de línea");

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.append("En un lugar de la Mancha de cuyo nombre no quiero acordarme");
            }
        });
        saltoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saltar = !jTextArea.getLineWrap();
                jTextArea.setLineWrap(saltar);
                if (saltar) saltoButton.setText("Quitar salto");
                else saltoButton.setText("Salto de línea");
            }
        });

        northPanel.add(insertButton);
        northPanel.add(saltoButton);


        jTextArea = new JTextArea(8,20);
        jTextArea.setLineWrap(true); // salto de línea cuando se llegue al extremo
        JScrollPane scrollPane = new JScrollPane(jTextArea); // Barra de desplazamiento
        centerPanel.add(scrollPane);

        JButton jButton = new JButton("GO");
        jButton.addActionListener(new ManageArea());
        centerPanel.add(jButton);



        setVisible(true);
    }


    private class ManageArea implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(jTextArea.getText());
        }
    }
}
