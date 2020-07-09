package l036_Herencia;

import java.util.Date;
import java.util.GregorianCalendar;

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
    }
}

