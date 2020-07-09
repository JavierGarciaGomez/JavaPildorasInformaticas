package L86_110CompSwing.l95Combobox;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JLabel texto;
    private JPanel northPanel, centerPanel;
    private JComboBox jComboBox;

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
        centerPanel.setLayout(new BorderLayout());
        panel.add(centerPanel, BorderLayout.CENTER);

        texto=new JLabel("En un lugar de la Mancha");
        texto.setFont(new Font("Serif", Font.PLAIN, 18));
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(texto, BorderLayout.CENTER);

        jComboBox = new JComboBox();
        jComboBox.addItem("Serif");
        jComboBox.addItem("Arial");
        jComboBox.addItem("SansSerif");
        jComboBox.setEditable(true);


        jComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jComboBox.getSelectedItem());
                texto.setFont(new Font((String) jComboBox.getSelectedItem(), Font.PLAIN, 18));
            }
        });

        northPanel.add(jComboBox);

        setVisible(true);
    }

}
