package l179_189Colecciones.l189HashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Empleado> personal = new HashMap<>();
        personal.put("AAA", new Empleado("Alberto", 250));
        personal.put("BBB", new Empleado("Bernardo", 250));
        personal.put("CCC", new Empleado("Carlos", 250));

        System.out.println(personal);

        personal.remove("BBB");

        System.out.println(personal);

        // Reemplaza
        personal.put("CCC", new Empleado("Natalia", 250));
        System.out.println(personal);

        //EntrySet, los imprime con un EntrySet
        System.out.println(personal.entrySet());

        // Por cada entrada de tipo map revisa lo que haya en el entryset de Personal
        for(Map.Entry<String, Empleado> entrada: personal.entrySet()){
            System.out.println(entrada.getKey());
            System.out.println(entrada.getValue());
        }
    }



}

class Empleado{
    private String nombre;
    private double sueldo;

    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}