package L86_110CompSwing.l86_87JLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private JTextField jTextField;
    private JLabel label;

    public MainFrame(){
        setBounds(600, 300, 600, 350);


        // JPanels and layouts
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(new BorderLayout());
        this.add(panel);
        JPanel northPanel = new JPanel();
        panel.add(northPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        panel.add(centerPanel, BorderLayout.CENTER);

        // North Panel
        JLabel jLabel = new JLabel("E-mail");
        northPanel.add(jLabel);

        jTextField = new JTextField("Texto por defecto", 20);
        jTextField.setText("e-mail");
        jTextField.addMouseListener(new MyMouseAdapter());
        northPanel.add(jTextField);

        JButton jButton = new JButton("Comprobar");
        jButton.addActionListener(new GetText());
        northPanel.add(jButton);

        // South Panel
        label = new JLabel();
        label.setFont(new Font("Arial", Font.ITALIC, 24));
        centerPanel.add(label);



        setVisible(true);
    }


    class MyMouseAdapter extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            jTextField.setText("");
        }
    }


    private class GetText implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(jTextField.getText());
            String cadena = jTextField.getText();
            boolean hasArroba=false;
            for (int i=0; i<cadena.length(); i++){
                if (cadena.charAt(i)=='@'){
                    hasArroba=true;
                    break;
                }
            }

            if (hasArroba){
                label.setText("Sí es un email");
                label.setForeground(Color.GREEN);
            }
            else {
                label.setText("No es un email");
                label.setForeground(Color.RED);
            }
        }
    }
}
