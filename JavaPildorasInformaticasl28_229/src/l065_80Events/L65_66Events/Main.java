package l065_80Events.L65_66Events;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame jFrame = new JFrame("MiMarco");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(700,300,500,300);
        Panel panel = new Panel();
        jFrame.setContentPane(panel);
    }
}
