package l179_189Colecciones.l179_183HashSet;

public class Cliente {
    private String nombre, noCuenta;
    private double sueldo;

    public Cliente(String nombre, String noCuenta, double sueldo) {
        this.nombre = nombre;
        this.noCuenta = noCuenta;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", noCuenta='" + noCuenta + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }

    // Generando el Hashcode y el equals con IDE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return noCuenta.equals(cliente.noCuenta);
    }

    @Override
    public int hashCode() {
        return noCuenta.hashCode();
    }
}
