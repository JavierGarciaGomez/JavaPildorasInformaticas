package l049_54InterfacesClasesInternas;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

// Modificaciones: 49, 50, 51

public class MainEmpleado {
    public static void main(String[] args) {

        GregorianCalendar calendar = new GregorianCalendar(2012,4,30);
        Date alta = calendar.getTime();
        Empleado empleado = new Empleado("Juan Fuentes", 2500, alta);
        //         Empleado empleado = new Empleado("Juan Fuentes", 2500, (new GregorianCalendar(2012,4,30).getTime()));
        Empleado empleado2 = new Empleado("Ana López", 3500, (new GregorianCalendar(2010,11,25).getTime()));
        Empleado empleado3 = new Empleado("María Martín", 5500, (new GregorianCalendar(2000,11,25).getTime()));
        // Empleado creado con sobrecarga de constructores
        Empleado empleado4 = new Empleado("María Mathos");
        System.out.println(empleado.toString());
        empleado.subeSueldo(10);
        System.out.println(empleado.toString());
        Empleado[] empleados = new Empleado[Empleado.getNumEmp()];
        System.out.println(Empleado.getNumEmp());
        empleados[0]=empleado;
        empleados[1]=empleado2;
        empleados[2]=empleado3;
        empleados[3]=empleado4;


        for(Empleado emp:empleados){
            System.out.println(emp.toString());
            emp.subeSueldo(50);
            System.out.println(emp.toString());
        }

        Jefe jefe1 = new Jefe("Orlando Pérez", 10000, new GregorianCalendar(2005, 3, 12).getTime());
        jefe1.setIncentivo(3000);
        System.out.println(jefe1.toString());
        jefe1.subeSueldo(10);
        System.out.println(jefe1.toString());

        // 49. Interfaces
        // Implemento la interfaz Comaparable en la clase Empleado
        // Desarrollo su método CompareTo, con base en el sueldo.
        // Clase Arrays y su método sort

        System.out.println("Ordenando");
        Arrays.sort(empleados);

        for(Empleado emp:empleados){
            System.out.println(emp.toString());
        }

        // 50. Interfaces 2
        System.out.println("\n\n LECCIÓN 50");

        Empleado director_comercial = new Jefe("Sandra", 8000, new GregorianCalendar(2000,1,1).getTime());

        // Implementar directamente el método de una interfaz
        Comparable ejemplo = new Empleado("Elisabeth", 95000, null);
        if(director_comercial instanceof Empleado){
            System.out.println("Es del tipo Empleado");
        }
        if(ejemplo instanceof Comparable) System.out.println("Implementa la interfaz comparable");

        // Método de la interfaz IJefe
        System.out.println(jefe1.tomadecision("todos tienen que llegar temprano, sino habrá descuentos"));

        // 51. Interfaces 3
        System.out.println("\n\n LECCIÓN 51");
        jefe1.setBonos(500);






    }
}

