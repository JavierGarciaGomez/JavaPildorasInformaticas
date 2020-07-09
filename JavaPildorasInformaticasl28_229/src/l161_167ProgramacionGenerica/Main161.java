package l161_167ProgramacionGenerica;

import java.util.ArrayList;
import java.util.Iterator;

public class Main161 {
    public static void main(String[] args) {


        ArrayList<Empleado> arEmpleados = new ArrayList<Empleado>(); // Creación del arraylist

		/* El constructor del arraylist acepta diez elementos, después de este hace una copia,
		de otros diez espacios, por lo que si se pretende un mínimo es mejor ponerlo con ensureCapacity:*/
        arEmpleados.ensureCapacity(11);

        arEmpleados.add(new Empleado("Ana", 45, 2500));
        arEmpleados.add(new Empleado("Antonio", 55, 2000));
        arEmpleados.add(new Empleado("María", 25, 2600));
        arEmpleados.add(new Empleado("Ana", 45, 2500));
        arEmpleados.add(new Empleado("Antonio", 55, 2000));
        arEmpleados.add(new Empleado("María", 25, 2600));
        arEmpleados.add(new Empleado("Maríoa", 25, 2600));


        // Para cortar el exceso de memoria se usa el método trim to size
        arEmpleados.trimToSize();

        System.out.println(arEmpleados.size());
        for (Empleado e : arEmpleados) {
            System.out.println(e.getData());
        }


        // 162.
        // Agregar un elemento y obtener
        arEmpleados.set(0, new Empleado("Javier", 33, 2000));
        System.out.println(arEmpleados.get(3).getData());

        // Creando un array con los elementos del arrayList
        Empleado newArEmp[] = new Empleado[arEmpleados.size()];
        arEmpleados.toArray(newArEmp);

        // 163. Iterator
        System.out.println("\n ITERATOR");
        Iterator<Empleado> myIterator=arEmpleados.iterator();

        while(myIterator.hasNext()) {
            System.out.println(myIterator.next().getData());
        }



    }
}

class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }


    public String getData() {
        return "El empleado " + nombre + " tiene " + edad + " años; y percibe un salario de " + salario;
    }
}

