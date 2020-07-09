package l065_80Events.L71EventoTecladk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(700,300,500,300);
        Panel panel = new Panel();
        setContentPane(panel);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println("Tecla presionada "+e.paramString()+
                        "\n"+e.getExtendedKeyCode()+
                        "\n"+e.getKeyChar()+
                        "\n"+e.getKeyCode()+
                        "\n"+e.getKeyLocation()+
                        "\n"+e.isActionKey());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

}
