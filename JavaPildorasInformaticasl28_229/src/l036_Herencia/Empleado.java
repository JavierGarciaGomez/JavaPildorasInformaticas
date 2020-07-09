package l036_Herencia;

import java.util.Date;

public class Empleado{
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
