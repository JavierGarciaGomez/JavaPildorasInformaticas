package L86_110CompSwing.l96_97JSlider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JLabel texto;
    private JPanel northPanel, centerPanel;
    private JSlider jSlider;

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

        jSlider = new JSlider(10, 48, 12);
        jSlider.setMajorTickSpacing(10);
        jSlider.setMinorTickSpacing(2);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        jSlider.setSnapToTicks(true);
        northPanel.add(jSlider);

        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                texto.setFont(new Font("Serif", Font.PLAIN, jSlider.getValue()));
            }
        });


        setVisible(true);
    }

}
