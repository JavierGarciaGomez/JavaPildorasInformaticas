package l142_151ExcepcionesDebugg;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main143 {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.setBounds(300,300,300,300);

        mainFrame.add(new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image myImage= ImageIO.read(new File("Morgana.png"));
                    g.drawImage(myImage,0,0,null);
                    } catch (IOException e) {
                    // e.printStackTrace();
                    System.out.println("La imagen no se encuentra");
                }

            }
        });

        mainFrame.setVisible(true);
    }


}
