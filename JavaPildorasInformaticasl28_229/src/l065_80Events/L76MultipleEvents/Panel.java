package l065_80Events.L76MultipleEvents;
// 66

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Implements ActionListener
public class Panel extends JPanel {

    // FIELDS


    // CONSTRUCTOR
    public Panel(){
        AccionColor accionAmarillo = new AccionColor ("Amarillo", new ImageIcon("AzzurraIcon.jpg"), Color.yellow);
        AccionColor accionMarron = new AccionColor ("Marrón", new ImageIcon("GinebraIcon.jpg"), Color.ORANGE);
        AccionColor accionRosa = new AccionColor ("Rosa", new ImageIcon("IconoMorgana.png"), Color.PINK);

        add(new JButton(accionAmarillo));
        add(new JButton(accionMarron));
        add(new JButton(accionRosa));

        // 79 Input Map
        InputMap inputMap =getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        //KeyStroke recibe una sintaxis de shift, control, alt, etc y la key.
        KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");
        //el método put de inputmap recibe un keystroke y un acción map
        inputMap.put(teclaAmarillo, "fondo_amarillo");
        // Forma simplificada
        inputMap.put(KeyStroke.getKeyStroke("ctrl M"), "fondo_marron");
        inputMap.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rosa");
        //ActionMap
        ActionMap actionMap = getActionMap();
        //Asignar con método put que recibe una key un Action
        actionMap.put("fondo_amarillo", accionAmarillo);
        actionMap.put("fondo_marron", accionMarron);
        actionMap.put("fondo_rosa", accionRosa);


    }



    private class AccionColor extends AbstractAction{
        public AccionColor(String nombre, Icon icono, Color color){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color "+nombre);
            putValue("colorFondo", color);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = (Color) getValue("colorFondo");
            setBackground(color);
        }
    }

    private class MyTest implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).toString());
        }
    }
}
