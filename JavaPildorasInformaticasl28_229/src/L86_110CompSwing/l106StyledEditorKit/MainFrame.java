package L86_110CompSwing.l106StyledEditorKit;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextPane jTextPane;
    private JPanel northPanel, centerPanel;
    JMenu fontMenu, styleMenu, sizeMenu;
    Font font;
    static String font2 = "Arial";
    static int style2 = 0;
    static int size2 = 12;


    public MainFrame() {
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

        jTextPane = new JTextPane();
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
        configMenu("Monospace", "Fuente", "Verdana", 2, 14);

        configMenu("Normal", "Estilo", "Serif", 0, 14);
        configMenu("Negrita", "Estilo", "Serif", 1, 14);
        configMenu("Cursiva", "Estilo", "Serif", 2, 14);
        configMenu("Negrita y cursiva", "Estilo", "Serif", 3, 14);

        configMenu("Pequeño", "Tamaño", "Serif", 2, 10);
        configMenu("Mediano", "Tamaño", "Serif", 2, 20);
        configMenu("Grande", "Tamaño", "Serif", 2, 40);
        configMenu("Enorme", "Tamaño", "Serif", 2, 80);


        setVisible(true);
    }

    public void configMenu(String rotulo, String menu, String font, int style, int size) {
        JMenuItem jMenuItem = new JMenuItem(rotulo);
        if (menu.equals(fontMenu.getText())) {
            fontMenu.add(jMenuItem);
            jMenuItem.addActionListener(new StyledEditorKit.FontFamilyAction("", font));

        }

        else if (menu.equals(styleMenu.getText())) {
            styleMenu.add(jMenuItem);
            if (style==Font.PLAIN) jMenuItem.addActionListener(new StyledEditorKit.BoldAction());
            else if (style==Font.BOLD) jMenuItem.addActionListener(new StyledEditorKit.BoldAction());
            else if (style==Font.ITALIC) jMenuItem.addActionListener(new StyledEditorKit.ItalicAction());
        }
        else if (menu.equals(sizeMenu.getText())) {
            sizeMenu.add(jMenuItem);
            jMenuItem.addActionListener(new StyledEditorKit.FontSizeAction("tamanio", size));
        }
    }
}
