package l111_122AplicacionesGraficas.l115_120DisposicionesAvanzadas;

import javax.swing.*;
import java.awt.*;

public class Main119 {
    public static void main(String[] args){
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Untitled");
        mainFrame.setBounds(600, 350, 500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new EnColumnas()); // Disposición libre

        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");
        JLabel telefono = new JLabel("Teléfono: ");
        JTextField nombreField = new JTextField(10);
        JTextField apellidoField = new JTextField(10);
        JTextField telefonoField = new JTextField(10);

//        nombre.setBounds(100, 100, 100, 20);
//        nombreField.setBounds(200, 100, 100, 20);
//        apellido.setBounds(100, 150, 100, 20);
//        apellidoField.setBounds(200,150,100,20);


        panel.add(nombre);
        panel.add(nombreField);
        panel.add(apellido);
        panel.add(apellidoField);
        panel.add(telefono);
        panel.add(telefonoField);

        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }

}

class EnColumnas implements LayoutManager{
    private int x=20;
    private int y=20;
    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        int d=parent.getWidth();
        x=d/2;

        int contador=0;

        int n=parent.getComponentCount(); // contador de componentes

        for (int i=0; i<n; i++){
            contador++;
            Component c= parent.getComponent(i);
            c.setBounds(x-100,y,100,20);
            x+=100;
            if (contador%2==0) {
                y+=40;
                x=d/2;
            }
        }

    }
}