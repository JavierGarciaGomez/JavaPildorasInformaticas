package L190_200Sockets.l192_199;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
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

class LaminaMarcoCliente extends JPanel implements Runnable{

    private JTextArea campoChat;
    private JTextField mensaje, nick, ip;
    private JButton miboton;

    public LaminaMarcoCliente(){
        nick=new JTextField(5);
        add(nick);

        JLabel texto=new JLabel("CHAT");
        add(texto);

        ip=new JTextField(8);
        add(ip);

        campoChat=new JTextArea(12,20);
        add(campoChat);

        mensaje=new JTextField(20);
        add(mensaje);
        miboton=new JButton("Enviar");

        EnviaTexto enviaTexto = new EnviaTexto();
        miboton.addActionListener(enviaTexto);

        add(miboton);

        Thread miHilo=new Thread(this);
        miHilo.start();
    }

    @Override
    public void run() {
        final int PUERTO = 9090;
        ServerSocket socketInput= null;
        try {
            socketInput = new ServerSocket(9090);
            Socket nuevoCliente;
            PaqueteTransferido paqueteRecibido;

            while(true){
                nuevoCliente = socketInput.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(nuevoCliente.getInputStream());
                paqueteRecibido= (PaqueteTransferido) objectInputStream.readObject();

                campoChat.append("\n"+paqueteRecibido.getNick()+": "+paqueteRecibido.getMensaje()+" para "+paqueteRecibido.getIp());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private class EnviaTexto implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                Socket miSocket = new Socket("192.168.1.137", 9999);

                PaqueteTransferido datosTransferidos = new PaqueteTransferido();
                datosTransferidos.setNick(nick.getText());
                datosTransferidos.setIp(ip.getText());
                datosTransferidos.setMensaje(mensaje.getText());

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(miSocket.getOutputStream());
                objectOutputStream.writeObject(datosTransferidos);

                miSocket.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        }
    }
}

class PaqueteTransferido implements Serializable {
    private String nick, ip, mensaje;

    // Getters y setters
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}


