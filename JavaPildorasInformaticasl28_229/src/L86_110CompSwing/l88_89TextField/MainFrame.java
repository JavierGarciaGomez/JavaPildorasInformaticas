package L86_110CompSwing.l88_89TextField;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

public class MainFrame extends JFrame {
    JLabel usuarioLabel, passLabel;
    JTextField usuarioField;
    JPasswordField passField;
    JButton sendButton;


    public MainFrame(){
        setBounds(600, 300, 600, 350);


        // JPanels and layouts
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(new BorderLayout());
        this.add(panel);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        panel.add(northPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);

        usuarioLabel = new JLabel("Usuario");
        passLabel = new JLabel("Contraseña");
        usuarioField = new JTextField();
        passField = new JPasswordField();
        Document document = passField.getDocument();
        document.addDocumentListener(new CompruebaPass());


        northPanel.add(usuarioLabel);
        northPanel.add(usuarioField);
        northPanel.add(passLabel);
        northPanel.add(passField);

        sendButton = new JButton("Enviar");
        centerPanel.add(sendButton);

        setVisible(true);
    }

    private class CompruebaPass implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            char[] password = passField.getPassword();
            if(password.length<8) passField.setBackground(Color.RED);
            if(password.length>=8) passField.setBackground(Color.GREEN);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("removeUpdate");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            System.out.println("changeUpdate");
        }
    }

}
