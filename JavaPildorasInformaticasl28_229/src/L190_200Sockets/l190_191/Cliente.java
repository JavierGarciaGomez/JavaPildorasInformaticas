package L190_200Sockets.l190_191;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MarcoCliente mimarco=new MarcoCliente();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCliente extends JFrame{
    public MarcoCliente(){
        setBounds(600,300,280,350);
        LaminaMarcoCliente milamina=new LaminaMarcoCliente();
        add(milamina);
        setVisible(true);
    }
}

class LaminaMarcoCliente extends JPanel {

    private JTextField campo1;
    private JButton miboton;

    public LaminaMarcoCliente(){
        JLabel texto=new JLabel("CLIENTE");
        add(texto);
        campo1=new JTextField(20);
        add(campo1);
        miboton=new JButton("Enviar");

        EnviaTexto enviaTexto = new EnviaTexto();
        miboton.addActionListener(enviaTexto);

        add(miboton);
    }

    private class EnviaTexto implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                Socket miSocket = new Socket("localhost", 4334);
                DataInputStream entrada = new DataInputStream(miSocket.getInputStream());
                DataOutputStream salida = new DataOutputStream(miSocket.getOutputStream());

                salida.writeUTF(campo1.getText());
                entrada.close();
                salida.close();
                miSocket.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        }
    }
}
