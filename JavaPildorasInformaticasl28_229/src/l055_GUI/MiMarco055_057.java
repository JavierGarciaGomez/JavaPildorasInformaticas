package l055_GUI;
// 55, 56, 57
import javax.swing.*;
import java.awt.*;

public class MiMarco055_057 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // Constantes de clase
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Frame extends JFrame {
    public Frame(){


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300,300);
        setSize(300,200);
        // SetBounds incluye setLocation y setSize
        setBounds(300,300,300,300);
        // setResizable() Permite o impide que se redimensione
        setResizable(false);
        // setExtendedState: para definir el estado
        //setExtendedState(MAXIMIZED_BOTH);
        //setUndecorated(true);
        //setOpacity(0.9F);
        setTitle("Título de la ventana");

        // 57. Marco centrado
        // Clase Toolkit: medio desde el cual estás ejecutando la pantalla
        // Método getDefaultToolkit()
        // Método getScreenSize()
        // Clase Dimension

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        System.out.println("Este es mi toolkit "+toolkit.toString());

        Dimension tamanoPantalla=toolkit.getScreenSize();
        System.out.println("Este es un objeto tipo dimensión" + tamanoPantalla.toString());

        // Extraigo las dimensiones
        int scrHeight = (int)tamanoPantalla.getHeight();
        int scrWidth = (int)tamanoPantalla.getWidth();
        // Que mi ventana ocupe la mitad de la pantalla
        setSize(scrWidth/2,scrHeight/2);
        // Ubicarlo en el centro
        setLocation(scrWidth/4,scrHeight/4);

        // Método getImage()
        Image icono = toolkit.getImage("iconoMorgana.png");
        // Método SetIconImage()
        setIconImage(icono);






        setVisible(true);
    }
}