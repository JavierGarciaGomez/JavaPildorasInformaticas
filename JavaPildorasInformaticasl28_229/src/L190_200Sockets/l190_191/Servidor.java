package L190_200Sockets.l190_191;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoServidor mimarco=new MarcoServidor();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoServidor extends JFrame implements Runnable {

    public MarcoServidor(){
        setBounds(1200,300,280,350);
        JPanel milamina= new JPanel();
        milamina.setLayout(new BorderLayout());
        areatexto=new JTextArea();
        milamina.add(areatexto,BorderLayout.CENTER);
        add(milamina);
        setVisible(true);

        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    private	JTextArea areatexto;

    @Override
    public void run() {
        final int PUERTO = 4334;
        ServerSocket serverSocket= null;
        try {
            serverSocket = new ServerSocket(PUERTO);

            while(true){
                Socket cliente = serverSocket.accept();
                System.out.println("Estoy a la escucha");
                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

                String mensaje = entrada.readUTF();
                areatexto.append("\n"+mensaje);
                entrada.close();
                salida.close();
                cliente.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}