package l111_122AplicacionesGraficas.l111_114ToolBars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    public MainFrame() throws HeadlessException {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(700, 300, 500, 300);
        mainPanel = new JPanel();
        add(mainPanel);

        AccionColor accionAmarillo = new AccionColor ("Amarillo", new ImageIcon("AzzurraIcon.jpg"), Color.yellow);
        AccionColor accionMarron = new AccionColor ("Marrón", new ImageIcon("GinebraIcon.jpg"), Color.ORANGE);
        AccionColor accionRosa = new AccionColor ("Rosa", new ImageIcon("IconoMorgana.png"), Color.PINK);
        Action accionSalir = new AbstractAction("Salir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        JMenu menu = new JMenu("Color");
        menu.add(accionRosa);
        menu.add(accionAmarillo);
        menu.add(accionMarron);

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(menu);
        setJMenuBar(jMenuBar);

        // Se crea la barra de herramientas y se agregan los acciones como botones.
        JToolBar toolBar = new JToolBar();
        add(toolBar, BorderLayout.NORTH);

        toolBar.add(accionAmarillo);
        toolBar.add(accionMarron);
        toolBar.add(accionRosa);

        toolBar.addSeparator();
        toolBar.add(accionSalir);

        // Separador de barra de herramientas
        toolBar.addSeparator();
        toolBar.setOrientation(1);


        setVisible(true);

    }

    private class AccionColor extends AbstractAction{
        public AccionColor(String nombre, Icon icono, Color color){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color "+nombre);
            putValue("colorFondo", color);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = (Color) getValue("colorFondo");
            mainPanel.setBackground(color);
        }
    }

}
