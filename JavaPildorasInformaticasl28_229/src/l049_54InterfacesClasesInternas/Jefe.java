package l049_54InterfacesClasesInternas;
// Modificaciones 50, 51


import java.util.Date;

public class Jefe extends Empleado implements IJefe {
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

    // 50 Implemento la interfaz IJefe y su método
    @Override
    public String tomadecision(String decision) {
        return this.getNombre()+" ha tomado la siguiente decisión: "+ decision.toUpperCase() ;
    }

    // 51 Implemento interfaz heredada
    @Override
    public double setBonos(double gratificacion) {
        double prima=2000;
        double bonoTotal=IEmpleado.bonusBase+prima;
        System.out.println(this.getNombre()+ "ha recibido un bono de "+bonoTotal);
        return bonoTotal;
    }
}
