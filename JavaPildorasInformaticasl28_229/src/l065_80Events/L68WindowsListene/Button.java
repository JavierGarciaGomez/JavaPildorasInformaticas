package l065_80Events.L68WindowsListene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {
    public Button() {
        setText("Píntame de rojo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setBackground(Color.RED);

    }
}
