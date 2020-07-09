package l065_80Events.L69WindowAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(700,300,500,300);
        Panel panel = new Panel();
        setContentPane(panel);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("minimiza");
            }

            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                System.out.println("Ventana abierta");
            }
        });

        // 70 WINDOWS STATE LISTENER
        addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                super.windowStateChanged(e);
                String estadoInicial, estadoFinal;
                switch (e.getOldState()){
                    case 0: estadoInicial="Normal";                        break;
                    case 1: estadoInicial="CrossHair Cursor";                        break;
                    case 6: estadoInicial="MAXIMIZED BOTH";                        break;
                    case 7: estadoInicial="NE_RESIZE CURSOR";                        break;
                    default: estadoInicial="No sé"; break;
                }

                System.out.println(e.getWindow()+ "\nPASSED FROM "+e.getOldState()+estadoInicial+"\n TO "+e.getNewState());

            }
        });

    }

}
