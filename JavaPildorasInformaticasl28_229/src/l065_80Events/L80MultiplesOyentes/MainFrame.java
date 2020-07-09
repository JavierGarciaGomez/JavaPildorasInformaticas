package l065_80Events.L80MultiplesOyentes;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(700, 300, 500, 300);
        Panel panel = new Panel();
        setContentPane(panel);
        setVisible(true);
    }

}
