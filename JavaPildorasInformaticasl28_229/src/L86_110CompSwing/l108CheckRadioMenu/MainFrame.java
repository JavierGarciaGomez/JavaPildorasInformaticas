package L86_110CompSwing.l108CheckRadioMenu;

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

        JMenuBar jMenuBar = new JMenuBar();
        fontMenu = new JMenu("Fuente");
        styleMenu = new JMenu("Estilo");
        sizeMenu = new JMenu("Tamaño");
        jMenuBar.add(fontMenu);
        jMenuBar.add(styleMenu);
        jMenuBar.add(sizeMenu);

        northPanel.add(jMenuBar);

        configMenu("Arial", "Fuente", "Arial", 2, 14);
        configMenu("Courier", "Fuente", "Courier", 2, 14);
        configMenu("Verdana", "Fuente", "Verdana", 2, 14);

        JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");
        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");
        styleMenu.add(negrita);
        styleMenu.add(cursiva);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton pequeno = new JRadioButton("Pequeño");
        JRadioButton mediano = new JRadioButton("Mediano");
        JRadioButton grande = new JRadioButton("Grande");

        buttonGroup.add(pequeno);
        buttonGroup.add(mediano);
        buttonGroup.add(grande);

        sizeMenu.add(pequeno);
        sizeMenu.add(mediano);
        sizeMenu.add(grande);



        setVisible(true);
    }

    public void configMenu (String rotulo, String menu, String font, int style, int size){
             JMenuItem jMenuItem =  new JMenuItem(rotulo);
             if(menu.equals(fontMenu.getText())) fontMenu.add(jMenuItem);
             else if (menu.equals(styleMenu.getText())) styleMenu.add(jMenuItem);
             else if (menu.equals(sizeMenu.getText())) sizeMenu.add(jMenuItem);

        jMenuItem.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if(menu.equals(fontMenu.getText())) font2=font;
                     else if (menu.equals(styleMenu.getText())) style2=style;
                     else if (menu.equals(sizeMenu.getText())) size2=size;

                    jTextPane.setFont(new Font(font2, style2, size2));
                    System.out.println(font2+" "+style2+" "+size2);
                 }
             });
    }
}
