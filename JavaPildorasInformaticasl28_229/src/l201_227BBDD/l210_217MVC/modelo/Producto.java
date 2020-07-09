package l201_227BBDD.l210_217MVC.modelo;

public class Producto {
    private String nombre;
    private String seccion;
    private double precio;
    private String pais;

    public Producto() {
        this.nombre="";
        this.seccion="";
        this.precio=0;
        this.pais="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
