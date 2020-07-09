package L86_110CompSwing.l92CheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JLabel texto;
    private JCheckBox check1, check2;

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

        Font font = new Font("Serif", Font.PLAIN, 24);
        texto = new JLabel("En un lugar de la mancha");
        texto.setFont(font);

        centerPanel.add(texto);

        check1 = new JCheckBox("Negrita");
        check2 = new JCheckBox("Cursiva");

        northPanel.add(check1);
        northPanel.add(check2);

        check1.addActionListener(new CheckListener());
        check2.addActionListener(new CheckListener());

        setVisible(true);
    }

    private class CheckListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int tipo=0;
            if(check1.isSelected()) tipo+=Font.BOLD;
            if(check2.isSelected()) tipo+=Font.ITALIC;

            texto.setFont(new Font("Serif", tipo, 24));


        }
    }
}
