package L190_200Sockets.l192_199;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
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

    private	JTextArea areatexto;

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


    @Override
    public void run() {

        try {
            ServerSocket servidor = new ServerSocket(9999);
            String nick, ip, mensaje;

            PaqueteTransferido paqueteRecibido;

            while(true){
                Socket miSocket = servidor.accept();
                areatexto.append("miSocket: "+String.valueOf(InetAddress.getLocalHost().getHostAddress()));
                ObjectInputStream objectInputStream = new ObjectInputStream(miSocket.getInputStream());
                paqueteRecibido = (PaqueteTransferido) objectInputStream.readObject();
                ip=paqueteRecibido.getIp();
                nick=paqueteRecibido.getNick();
                mensaje=paqueteRecibido.getMensaje();

                areatexto.append("\n"+nick+": "+mensaje+" para "+ip);

                // Socket para enviar información
                Socket socketDestinatario=new Socket(ip, 9090);
                ObjectOutputStream paqueteReenvio=new ObjectOutputStream(socketDestinatario.getOutputStream());
                paqueteReenvio.writeObject(paqueteRecibido);

                paqueteReenvio.close();

                socketDestinatario.close();
                miSocket.close();
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}