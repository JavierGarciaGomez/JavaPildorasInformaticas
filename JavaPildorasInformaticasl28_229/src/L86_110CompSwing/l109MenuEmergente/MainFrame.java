package L86_110CompSwing.l109MenuEmergente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextPane jTextPane;
    private JPanel northPanel, centerPanel;
    JMenu fontMenu, styleMenu, sizeMenu;
    Font font;
    static String font2="Arial";
    static int style2=0;
    static int size2=12;


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

        jTextPane=new JTextPane();
        centerPanel.add(jTextPane, BorderLayout.CENTER);

        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem opcion1 = new JMenuItem("Opción 1");
        JMenuItem opcion2 = new JMenuItem("Opción 2");
        JMenuItem opcion3 = new JMenuItem("Opción 3");

        jPopupMenu.add(opcion1);
        jPopupMenu.add(opcion2);
        jPopupMenu.add(opcion3);

        jTextPane.setComponentPopupMenu(jPopupMenu);



        setVisible(true);
    }

}
