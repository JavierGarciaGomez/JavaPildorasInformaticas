package l065_80Events.L72MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(700, 300, 500, 300);
        Panel panel = new Panel();
        setContentPane(panel);
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                System.out.println("Tengo el foco");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                System.out.println("Ya no tengo el foco");
            }
        });
    }

}
