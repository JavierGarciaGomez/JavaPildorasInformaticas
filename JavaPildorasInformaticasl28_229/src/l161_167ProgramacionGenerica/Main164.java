package l161_167ProgramacionGenerica;

import java.io.File;

public class Main164 {
    public static void main(String[] args) {
        NewArrayList archivos = new NewArrayList(5);
        archivos.add("Juan");
        archivos.add("María");
        archivos.add("Ana");
        archivos.add("Sandra");

        String nombrePersona= (String) archivos.get(2);
        System.out.println(nombrePersona);

        archivos.add(new File("resources\\gestionPedidos.accd"));
        File nombreArchivo=(File)archivos.get(4);
        System.out.println(nombreArchivo);

        // 165
        // La clase genérica hace que se prepare para recibir el objeto que determino al instanciar la clase genérica
        Pareja<String> una = new Pareja<String>();
        una.setPrimero("Mi instancia genérica");
        una.getPrimero();

        Empleado empleado = new Empleado("Javier",35, 1000);
        Pareja<Empleado> empleadoPareja = new Pareja<>();
        // Se adapta la clase para recibir no un String, sino un empleado
        empleadoPareja.setPrimero(empleado);

        // 166
        String [] arrayStrings = new String [5];
        Empleado [] arrayInt = new Empleado[7];
        System.out.println(MisMatices.getElementos(arrayStrings));
        System.out.println(MisMatices.getElementos(arrayInt));


    }
}

class MisMatices{
    // T[] a es un array genérico
    public static<T> String getElementos(T[]arrayGenerico){
        return "El array tiene " + arrayGenerico.length;
    }


}