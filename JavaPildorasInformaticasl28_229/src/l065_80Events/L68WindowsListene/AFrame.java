package l065_80Events.L68WindowsListene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AFrame extends JFrame implements WindowListener {
    public AFrame() throws HeadlessException {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(700,300,500,300);
        Panel panel = new Panel();
        setContentPane(panel);
        addWindowListener(this);

    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("WindowOpened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("WindowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("WindowDeiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("WindowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("WindowDeactivated");
    }
}
