package L86_110CompSwing.l100Menus;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JLabel texto;
    private JPanel northPanel, centerPanel;
    private JSpinner jSpinner;

    public MainFrame(){
        setBounds(600, 300, 600, 350);

        // JPanels and layouts
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(new BorderLayout());
        this.add(panel);
        northPanel = new JPanel();
        panel.add(northPanel, BorderLayout.NORTH);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        panel.add(centerPanel, BorderLayout.CENTER);

        texto=new JLabel("En un lugar de la Mancha");
        texto.setFont(new Font("Serif", Font.PLAIN, 18));
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(texto, BorderLayout.CENTER);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        JMenu menuTools = new JMenu("Tools");
        jMenuBar.add(menuFile);
        jMenuBar.add(menuEdit);
        jMenuBar.add(menuTools);

        menuFile.add(new JMenuItem("Open"));
        menuFile.add(new JMenuItem("Close"));

        menuEdit.add(new JMenuItem("Copy"));
        menuEdit.add(new JMenuItem("Paste"));

        menuTools.add(new JMenuItem("Generales"));

        northPanel.add(jMenuBar);




        setVisible(true);
    }



}
