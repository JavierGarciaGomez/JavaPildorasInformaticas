package L86_110CompSwing.l98_99JSpinner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MainFrame extends JFrame {
    private JLabel texto;
    private JPanel northPanel, centerPanel;
    private JSpinner jSpinner;

    public MainFrame(){
        setBounds(600, 300, 600, 350);

        // JPanels and layouts
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(new BorderLayout());
        this.add(panel);
        northPanel = new JPanel();
        panel.add(northPanel, BorderLayout.NORTH);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        panel.add(centerPanel, BorderLayout.CENTER);

        texto=new JLabel("En un lugar de la Mancha");
        texto.setFont(new Font("Serif", Font.PLAIN, 18));
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(texto, BorderLayout.CENTER);

        // String fontList [] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        // jSpinner = new JSpinner(new SpinnerListModel(fontList));

        // Ejercicico tradicional sobreescribiendo métodos en clase interna
        // jSpinner = new JSpinner(new MySpinnerNumberModel());
        jSpinner = new JSpinner(new SpinnerNumberModel(5,0,10,1){
            @Override
            public Object getNextValue() {
                return super.getPreviousValue();
            }
            @Override
            public Object getPreviousValue() {
                return super.getNextValue();
            }
        });

        jSpinner.setPreferredSize(new Dimension(150, 20));
        northPanel.add(jSpinner);



        setVisible(true);
    }

    /* Clase interna
    private class MySpinnerNumberModel extends SpinnerNumberModel{
        public MySpinnerNumberModel(){
            super(5, 0,10,1);
        }

        @Override
        public Object getNextValue() {
            return super.getPreviousValue();
        }

        @Override
        public Object getPreviousValue() {
            return super.getNextValue();
        }
    }
    */


}
