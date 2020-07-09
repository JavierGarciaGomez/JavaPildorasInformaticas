package l036_Herencia;

public class Furgoneta extends Vehiculo {
    private int capacidad_extra;
    private int plazas_extra;

    public Furgoneta(int plazas_extra, int capacidad_extra){
        super();
        this.capacidad_extra=capacidad_extra;
        this.plazas_extra=plazas_extra;
    }

    @Override
    public String toString() {
        return "Furgoneta{" + super.toString() +
                "capacidad_extra=" + capacidad_extra +
                ", plazas_extra=" + plazas_extra +
                "}";
    }
}
