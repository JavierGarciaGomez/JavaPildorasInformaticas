package l123_131Ejercicio;

import l123_131Ejercicio.RadioButtonPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeListener;
import java.util.Date;

public class MainFrame extends JFrame {
    private RadioButtonPanel tipoPanel, tipoMensajesPanel, mensajePanel, confirmarPanel, opcionPanel, entradaPanel;
    private String cadenaMensaje = "Mensaje";
    private Icon iconoMensaje = new ImageIcon("iconoMorgana.png");
    private Object objetoMensaje = new Date();
    private Component componenteMensaje = new LaminaEjemplo();

    public MainFrame() {
        setTitle("Dialog frame");
        setBounds(500, 300, 600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Láminas y agregar
        JPanel mainPanel, centerPanel, southPanel;
        mainPanel = new JPanel(new BorderLayout());
        centerPanel = new JPanel(new GridLayout(2, 3));
        southPanel = new JPanel();

        this.add(mainPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // Láminas de RadioButton en CenterPanel
        tipoPanel = new RadioButtonPanel("Tipo", new String[]{"Mensaje", "Confirmar", "Opción", "Entrada"});
        tipoMensajesPanel = new RadioButtonPanel("Tipo de mensajes", new String[]{
                "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"});
        mensajePanel = new RadioButtonPanel("Mensaje", new String[]{
                "Cadena", "Ícono", "Componente", "Otros", "Object[]"});
        confirmarPanel = new RadioButtonPanel("Confirmar", new String[]{"DEFAULT_OPTION", "YES_NO_OPTION",
                "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"});
        opcionPanel = new RadioButtonPanel("Opción", new String[]{"String[]", "Icon[]", "Object[]"});
        entradaPanel = new RadioButtonPanel("Entrada", new String[]{"Campo de texto", "Combo"});

        centerPanel.add(tipoPanel);
        centerPanel.add(tipoMensajesPanel);
        centerPanel.add(mensajePanel);
        centerPanel.add(confirmarPanel);
        centerPanel.add(opcionPanel);
        centerPanel.add(entradaPanel);

        // South Panel
        JButton mostrarButton = new JButton("Mostrar");
        southPanel.add(mostrarButton);
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tipoPanel.getSelection().equals("Mensaje"))
                    JOptionPane.showMessageDialog(MainFrame.this, getMessage(), "Title", getTypeMessage());
                else if (tipoPanel.getSelection().equals("Confirmar"))
                    JOptionPane.showConfirmDialog(MainFrame.this, getMessage(), "Title", getConfirmar(), getTypeMessage(), null);
                else if (tipoPanel.getSelection().equals("Opción"))
                    JOptionPane.showOptionDialog(MainFrame.this, getMessage(), "Title", getConfirmar(), getTypeMessage(), null, getOpciones(), 0);
                else if (tipoPanel.getSelection().equals("Entrada")){
                    if(entradaPanel.getSelection().equals("Campo de texto")) JOptionPane.showInputDialog(MainFrame.this, getMessage(), "Title", getTypeMessage());
                    else JOptionPane.showInputDialog(MainFrame.this, getMessage(), "Title", getTypeMessage(), null, new Object[]{"Rojo", "Verde", "Amarillo"}, 0);
                }


            }
        });


        setVisible(true);
    }

    // internal classes

    private class LaminaEjemplo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
            g2.setPaint(Color.YELLOW);
            g2.fill(rectangle2d);

        }
    }

    // Methods
    public Object getMessage() {
        String s = mensajePanel.getSelection();
        if (s.equals("Cadena")) return cadenaMensaje;
        else if (s.equals("Ícono")) return iconoMensaje;
        else if (s.equals("Componente")) return componenteMensaje;
        else if (s.equals("Otros")) return objetoMensaje;
        else if (s.equals("Object[]")) {
            return new Object[]{cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje};
        } else return null;
    }

    public int getTypeMessage() {
        String s = tipoMensajesPanel.getSelection();
        if (s.equals("ERROR_MESSAGE")) return 0;
        else if (s.equals("INFORMATION_MESSAGE")) return 1;
        else if (s.equals("WARNING_MESSAGE")) return 2;
        else if (s.equals("PLAIN_MESSAGE")) return -1;
        else if (s.equals("QUESTION_MESSAGE")) return 3;

        else return 0;

    }

    public int getConfirmar() {
        String s = confirmarPanel.getSelection();
        if (s.equals("DEFAULT_OPTION")) return -1;
        else if (s.equals("YES_NO_OPTION")) return 0;
        else if (s.equals("YES_NO_CANCEL_OPTION")) return 1;
        else if (s.equals("OK_CANCEL_OPTION")) return 2;
        else return 0;
    }

    public Object[] getOpciones() {
        String s = opcionPanel.getSelection();
        if (s.equals("String[]")) {
            System.out.println("JIJI");
            return new Object[] {"Opción1", "Opción2", "Opción3"};
        }
        else if (s.equals("Icon[]")) return new Object[] {new ImageIcon("iconoMorgana.png"), new ImageIcon("AzzurraIcon.jpg"), new ImageIcon("GinebraIcon.jpg")};
        else if (s.equals("Object[]")) return new Object[]{cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje};
        else return null;
    }

}
