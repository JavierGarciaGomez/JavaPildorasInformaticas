package l028_035POO;

public class Coche28_32 {
    //CAMPOS
    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int peso;
    private String color;
    private boolean climatizador;

    // CONSTRUCTOR
    public Coche28_32(){
        ruedas=4;
        largo=2000;
        ancho=300;
        motor=1600;
        peso=500;
    }

    // GETTERS AND SETTERS

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isClimatizador() {
        return climatizador;
    }

    public void setClimatizador(boolean climatizador) {
        this.climatizador = climatizador;
        aumentapeso();
    }


    @Override
    public String toString() {
        return "Coche{" +
                "ruedas=" + ruedas +
                ", largo=" + largo +
                ", ancho=" + ancho +
                ", motor=" + motor +
                ", peso=" + peso +
                ", color='" + color + '\'' +
                (climatizador?"tiene climatizado":"no tiene climatizador")+
                '}';
    }

    // METODOS
    public void aumentapeso(){
        if(climatizador) peso+=200;
    }

    public double getPrecio(){
        int precioBase=10000;
        double precioFinal=precioBase;
        if(climatizador) precioFinal=precioBase+2000;
        return precioFinal;

    }




}
