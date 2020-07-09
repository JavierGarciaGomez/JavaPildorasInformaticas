package l055_GUI;
// 58, 59

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class Main058_Frames {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(300, 300, 300, 300);

        Lamina lamina = new Lamina();
        frame.setContentPane(lamina);
        // 61
        frame.setBackground(Color.BLUE);
        frame.setVisible(true);

    }
}

class Lamina extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //  58
        g.drawString("Estoy aprendiendo Java", 0, 200);

        // 59
        g.drawRect(50, 50, 200, 200);
        g.drawLine(10, 100, 300, 200);
        g.drawArc(150, 150, 100, 200, 120, 150);

        // 60
        Graphics2D g2 = (Graphics2D) g; // Refundición
        Rectangle2D rectangulo = new Rectangle2D.Double(250, 250, 200, 150);

        g2.draw(rectangulo); // dibujar contorno
        g2.setPaint(Color.ORANGE); // Color
        g2.draw(rectangulo); // shape a dibujar


        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.draw(elipse);


        g2.setPaint(Color.RED.brighter().brighter()); // Brighter para hacer lo más claro y darker para más oscuro.
        g2.fill(elipse);


        g2.draw(new Line2D.Double(100, 100, 300, 250));

        // Dibujar un círculo
        double centroX = rectangulo.getCenterX();
        double centroY = rectangulo.getCenterY();
        double radio = 150;

        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(centroX, centroY, centroX + radio, centroY + radio);
        g2.draw(circulo);

        //62 Fuentes
        Graphics2D g3 = (Graphics2D) g; // Refundición

        // Se instancia la clase fuente
        Font myFont = new Font("Arial", Font.BOLD, 24);

        // Se establece la fuente
        g3.setFont(myFont);

        //Con este método se establece el color de la fuente
//		g2.setColor(Color.WHITE);
        g3.drawString("Fuente variada", 100, 100); // Se dibuja el texto

        // Se instancia la fuente desde el mismo método setFont
        g3.setFont(new Font("Arial", Font.ITALIC, 40));
        g3.drawString("Otro texto", 200, 200);

        //63 Imágenes
        Image myImage = null;
        try {
            myImage = ImageIO.read(new File("Morgana.png"));

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        //Se inserta la imagen
        g.drawImage(myImage, 10, 10, null);

        // 64. Imagenes 2

        try {
            myImage = ImageIO.read(new File("iconoMorgana.png"));

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        int hImage = myImage.getHeight(null);
        int wImage = myImage.getWidth(null);


        //CopyArea de la imagen
        g.copyArea(0, 0, 50, 50, 0, 100);

        // Hacer mosaico con for
        for (int i = 0; i < 500; i += hImage) {
            for (int j = 0; j < 500; j += wImage) {
                g.copyArea(0, 0, 50, 50, i, j);
            }

            g.copyArea(0, 0, 50, 50, i, 0);
        }

    }
}
