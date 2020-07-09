package l036_Herencia;

public class MainVehiculo {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        // L31 Paso de parametros
        vehiculo.setColor("azul");
        System.out.println(vehiculo.toString());
        vehiculo.setClimatizador(true);
        System.out.println(vehiculo.toString());
        System.out.println("El precio final del coche es: "+ vehiculo.getPrecio());

        Furgoneta furgoneta = new Furgoneta(4, 100);
        System.out.println(furgoneta);



    }
}
