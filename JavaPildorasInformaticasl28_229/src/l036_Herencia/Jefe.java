package l036_Herencia;

import java.util.Date;

public class Jefe extends Empleado {
    // FIELDS
    private double incentivo;
    // Constructor
    public Jefe(String nombre, double sueldo, Date altaContrato) {
        super(nombre, sueldo, altaContrato);
    }

    public void setIncentivo(double incentivo){
        this.incentivo=incentivo;
        super.setSueldo(super.getSueldo()+incentivo);
    }
}
