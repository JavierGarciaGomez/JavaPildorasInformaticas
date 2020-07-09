package l028_035POO;

import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado033 {
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
    }
}

class Empleado{
    private static int numEmp;
    private final String nombre;
    private double sueldo;
    private Date altaContrato;
    private int id;

    // CONSTRUCTOR
    public Empleado(String nombre, double sueldo, Date altaContrato) {
        System.out.println("Creando empleado");
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.altaContrato = altaContrato;
        numEmp+=1;
        this.id=numEmp;
    }

    // 39. Sobrecarga de constructores
    public Empleado(String nombre){
        this(nombre, 20000, null);
    }


    //GETTERS SETTERS TO STRING


    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getAltaContrato() {
        return altaContrato;
    }

    public void setAltaContrato(Date altaContrato) {
        this.altaContrato = altaContrato;
    }

    public static int getNumEmp() {
        return numEmp;
    }

    public static void setNumEmp(int numEmp) {
        Empleado.numEmp = numEmp;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", altaContrato=" + altaContrato +
                '}';
    }

    // METHODS

    public void subeSueldo(double porcentajeAumento){
        sueldo = sueldo + (sueldo * (porcentajeAumento/100));
    }

}

