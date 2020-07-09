package l142_151ExcepcionesDebugg;

import javax.swing.*;

public class Main148 {
    public static void main(String[] args) {
        try {
            division();
        }catch(ArithmeticException e){
            System.out.println("No se puede dividir entre cero"+e.getMessage()+e.getClass().getName());
        }catch(NumberFormatException e){
            System.out.println("No has introducido un número");
        }

    }

    static void division() {
        int num1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
        int num2=Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));

        System.out.println("El resultado es: "+num1/num2);
    }
}
