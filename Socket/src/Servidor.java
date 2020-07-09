import javax.swing.*;
import java.awt.*;
import java.io.*;
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
                try{
                    areatexto.append("miSocket: "+String.valueOf(miSocket.getLocalAddress()));
                    areatexto.append("servidor getLocalAddress: "+String.valueOf(servidor.getLocalSocketAddress()));
                } catch (Exception excepcion){}

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