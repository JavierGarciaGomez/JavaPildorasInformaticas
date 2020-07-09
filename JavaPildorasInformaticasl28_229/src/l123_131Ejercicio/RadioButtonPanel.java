package l123_131Ejercicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonPanel extends JPanel {
    private JRadioButton jRadioButton;
    private ButtonGroup buttonGroup;

    RadioButtonPanel(String titulo, String[] opciones) {

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Disposición caja, acomodados verticalmente

        buttonGroup = new ButtonGroup();
        for (int i = 0; i < opciones.length; i++) {
            jRadioButton = new JRadioButton(opciones[i]);
            jRadioButton.setActionCommand(opciones[i]);
            this.add(jRadioButton);
            buttonGroup.add(jRadioButton);
            jRadioButton.setSelected(i == 0);
        }
    }

    public String getSelection() {
        return buttonGroup.getSelection().getActionCommand();
    }
}
